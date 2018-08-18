package student_marks_app.service;

import org.junit.Before;
import org.junit.Test;
import student_marks_app.domain.Student;
import student_marks_app.factory.StudentFactory;

import static org.junit.Assert.assertEquals;

public class StudentServiceTest {
    private String stud_no;
    private String stud_first_name;
    private String stud_last_name;
    private double stud_mark;
    StudentService service;

    @Before
    public void setUp()throws Exception{
        stud_no="2030646";
        stud_first_name="dylan";
        stud_last_name= "Baadjies";
        stud_mark = 60;

    }

    @Test
    public void getStudent() {
    }

    @Test
    public void saveStudent() {
        Student student = StudentFactory.createStudent(stud_no,stud_first_name, stud_last_name, stud_mark);
        service.saveStudent(student);
        assertEquals("dylan", student.getStud_first_name());
        System.out.println(student.getStud_first_name());

    }
}