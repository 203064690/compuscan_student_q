package student_marks_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import student_marks_app.domain.Student;
import student_marks_app.service.StudentService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    //View Reports
    @RequestMapping(value={"/view_student"}, method = RequestMethod.GET)
    public ModelAndView getAllCustomer(){
        List<Student> allStudents = new ArrayList<>();
        Iterable<Student> allCustomers2 = studentService.getAllStudent();
        for(Student student : allCustomers2){
            allStudents.add(student);
        }


        ModelAndView model = new ModelAndView();
        model.setViewName("reports/student_report");
        model.addObject("reports", allStudents);
        model.addObject("msg", "Student");
        return model;
    }

    //To display Main screen
    @RequestMapping(value= {"/", "/home"}, method = RequestMethod.GET)
    public ModelAndView student(){

        ModelAndView model = new ModelAndView();
        model.setViewName("student/home");
        return model;
    }

    //To display Student add screen
    @RequestMapping(value= {"/add_student"}, method = RequestMethod.GET)
    public ModelAndView ViewStudent(){

        ModelAndView model = new ModelAndView();
        model.setViewName("student/add_student");
        return model;
    }
    //To handel add Student screen
    @RequestMapping(value= {"/add_student"}, method=RequestMethod.POST)
    public ModelAndView addStudent(@ModelAttribute("Student") @Valid Student student, BindingResult bindingResult) {
        String result = "";
        System.out.println(student.toString());
        Student studentExists = studentService.getStudent(student.getStud_no());
        //System.out.println(userExists.toString());
        if(studentExists != null) {
            bindingResult.rejectValue("msg", "Student already exist");
        }
        if(bindingResult.hasErrors()) {
            result = studentService.saveStudent(student);
            ModelAndView model = new ModelAndView("student/add_student");
            model.addObject("msg", "Student already exist");
            System.out.println(result);
            return model;
        }

        else {
            result = studentService.saveStudent(student);
            ModelAndView model = new ModelAndView("student/home");
            model.addObject("student", studentExists);
            model.addObject("msg", "Student saved successfully!");
            System.out.println(result);
            return model;
        }

    }

    @RequestMapping(value= {"/add_mark"}, method = RequestMethod.GET)
    public ModelAndView addMark(){

        ModelAndView model = new ModelAndView();
        model.setViewName("student/add_mark");
        return model;
    }

    //To add Mark to specific student
    @RequestMapping(value= {"/add_mark"}, method=RequestMethod.POST)
    public ModelAndView updateStudentMark(@ModelAttribute("student") @Valid Student student, BindingResult bindingResult) {
        String result = "";
        System.out.println(student.toString());
        Student studentExists = studentService.getStudent(student.getStud_no());
        System.out.println(studentExists.toString());
        if(studentExists == null) {
            bindingResult.rejectValue("msg", "Student does not exist");
        }
        if(bindingResult.hasErrors()) {
            ModelAndView model = new ModelAndView("student/add_mark");
            model.addObject("msg", "Student does not exist");
            return model;
        }

        else {

            studentExists.setStud_mark(student.getStud_mark());
            result = studentService.updateStudent(studentExists);
            ModelAndView model = new ModelAndView("student/home");
            model.addObject("msg", "Student mark was saved!");
            System.out.println(result);
            return model;
        }

    }

    //To delete student
    @RequestMapping(value= {"/delete_student"}, method=RequestMethod.POST)
    public String deleteStudent(String stud_no) {
        String result;
        result = studentService.deleteStudent(stud_no);
        //ModelAndView model = new ModelAndView();
        //model.setViewName("errors/access_denied");
        return result;
    }

}
