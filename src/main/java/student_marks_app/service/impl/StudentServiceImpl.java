package student_marks_app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import student_marks_app.domain.Student;
import student_marks_app.factory.StudentFactory;
import student_marks_app.repository.StudentRepo;
import student_marks_app.service.StudentService;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo repositoryStudent;

    @Override
    public List<Student> getAllStudent() {
        List<Student> allUsers = new ArrayList<Student>();

        Iterable<Student> students = repositoryStudent.findAll();
        for (Student student : students) {
            allUsers.add(student);
        }
        return allUsers;
    }

    @Override
    public Student getStudent(String stud_no) {
        String strStudent = "";
        int countStud = 0;
        Student gotStudent = null;

        Iterable<Student> students = repositoryStudent.findAll();
        for (Student student : students) {
            if (student.getStud_no().equalsIgnoreCase(stud_no))
            {
                countStud = countStud + 1;
                gotStudent = student;
            }
        }
        if (countStud != 0)
        {
            strStudent = "Student: Found";
        }
        else
        {
            strStudent = "Username: Not Found";
        }

        return gotStudent;
    }

    @Override
    public String saveStudent(Student studentNew) {
        int count = 0;
        boolean blnCreateStudent;
        Iterable<Student> students = repositoryStudent.findAll();
        for (Student student : students) {
            if (student.getStud_no().equalsIgnoreCase(studentNew.getStud_no()))
            {
                count = count + 1;
            }
        }

        if (count == 0)
        {
            //userName.setPassword(bCryptPasswordEncoder.encode(userName.getPassword()));
            Student student = StudentFactory.createStudent(studentNew.getStud_no(), studentNew.getStud_firstName(), studentNew.getStud_lastName(), studentNew.getStud_mark());
            repositoryStudent.save(student);
            blnCreateStudent = true;
        }
        else
        {
            blnCreateStudent = false;
        }

        if(blnCreateStudent==true)
            return "User saved";
        else
            return "User not saved";
    }

    @Override
    public String deleteStudent(String stud_no) {
        Long studID = 0L;
        boolean blnDeleteStud = false;

        Iterable<Student> students = repositoryStudent.findAll();
        for (Student student : students) {
            if(student.getStud_no().equalsIgnoreCase(stud_no))
            {
                studID = student.getID();
                blnDeleteStud = true;
            }
        }
        if(blnDeleteStud == true)
        {
            repositoryStudent.deleteById(studID);
            return "User deleted";
        }
        else
            return "User cannot be deleted";
    }
}
