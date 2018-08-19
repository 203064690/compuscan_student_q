package student_marks_app.controller;

import org.junit.Before;
import org.junit.Test;
import student_marks_app.domain.Student;
import student_marks_app.factory.StudentFactory;
import student_marks_app.service.StudentService;

import static org.junit.Assert.*;

public class StudentControllerTest {
    StudentService service;
    Student student;

    @Before
    public void setUp() throws Exception {
        student = new Student.Builder("203064690")
                .stud_first_name("Dylan")
                .stud_last_name("Baadjies")
                .stud_mark(88)
                .build();

    }

    @Test
    public void getAllCustomer() {
        /*
        Iterable<Student> allCustomers2 = service.getAllStudent();
        for(Student student : allCustomers2){
            student.getStud_first_name();
        }
        assertEquals("Dylan", student.getStud_first_name());
*/
    }

    @Test
    public void getAllMarks() {
    }

    @Test
    public void addStudent() {
        /*
        Student stud = StudentFactory.createStudent(student.getStud_no(),
                student.getStud_first_name(),
                student.getStud_last_name(),
                student.getStud_mark());
        service.saveStudent(stud);
        assertEquals("Dylan", stud.getStud_first_name());
        System.out.println(student.getStud_first_name());
        */
    }

    @Test
    public void addMark() {
    }

    @Test
    public void updateStudentMark() {
    }

    @Test
    public void deleteStudent() {
        /*
        service.saveStudent(student);
        service.deleteStudent("203064690");
        Student delStud = service.getStudent("203064690");
        assertNull(delStud);
        */
    }
}