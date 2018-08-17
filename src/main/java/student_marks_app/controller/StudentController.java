package student_marks_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import student_marks_app.domain.Student;
import student_marks_app.service.StudentService;

import javax.validation.Valid;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/student/view_student")
    public @ResponseBody
    Iterable<Student> getAllStudent()
    {
        return studentService.getAllStudent();
    }

    //To display Student screen
    @RequestMapping(value= {"/", "/home"}, method = RequestMethod.GET)
    public ModelAndView student(){

        ModelAndView model = new ModelAndView();
        model.setViewName("student/home");
        return model;
    }

    //To display Student screen
    @RequestMapping(value= {"/add_student"}, method = RequestMethod.GET)
    public ModelAndView ViewStudent(){

        ModelAndView model = new ModelAndView();
        model.setViewName("student/add_student");
        return model;
    }

    @RequestMapping(value= {"/add_student"}, method=RequestMethod.POST)
    public String addStudent(@ModelAttribute("student") @Valid Student student, BindingResult bindingResult) {
        String result = "";
        Student studentExists = studentService.getStudent(student.getStud_no());
        //System.out.println(userExists.toString());
        if(studentExists != null) {
            bindingResult.rejectValue("msg", "Student already exist");
        }
        if(bindingResult.hasErrors()) {
            ModelAndView model = new ModelAndView("student/add_student");
            model.addObject("msg", "Student already exist");
            return result;
        }

        else {
            result = studentService.saveStudent(student);
            ModelAndView model = new ModelAndView("student/home");
            model.addObject("student", studentExists);
            model.addObject("msg", "Student saved successfully!");
            return result;
        }

    }

    @RequestMapping(value= {"/delete_student"}, method=RequestMethod.POST)
    public String deleteStudent(String stud_no) {
        String result;
        result = studentService.deleteStudent(stud_no);
        //ModelAndView model = new ModelAndView();
        //model.setViewName("errors/access_denied");
        return result;
    }
/*
    @GetMapping(path = "/user/get/{emailAddress}")
    public String getUserPost (@PathVariable String emailAddress){
        User getUser = null;
        String created;
        getUser =userService.getUser(emailAddress);
        created =getUser.toString();
        return created;
    }
    */
/*
    @RequestMapping(value = "/login", method = RequestMethod.POST) // Map ONLY Post Requests
    public String addUser (@RequestBody User userName) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        String created, created2;

       // created = userService.newUser(name, email);
        userService.saveUser(userName);
        return created2 = userName.getEmailAddress();
    }
*/
/*
    @RequestMapping(path = "/user/add")
    public @ResponseBody String addNewUser (@RequestParam String email
            , @RequestParam String password, @RequestParam String recoveryQuestion, @RequestParam String recoveryAnswer){
        String created;
        created = userService.newUser(email, password, recoveryQuestion, recoveryAnswer);
        return created;
    }
*/

}
