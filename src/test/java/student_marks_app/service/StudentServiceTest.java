package student_marks_app.service;

import org.junit.Before;
import org.junit.Test;
import student_marks_app.domain.Student;
import student_marks_app.factory.StudentFactory;

import static org.junit.Assert.assertEquals;

public class StudentServiceTest {
    Student student;
    StudentService service;

    @Before
    public void setUp()throws Exception{
        student = new Student.Builder("203064690")
                .stud_first_name("Dylan")
                .stud_last_name("Baadjies")
                .stud_mark(88)
                .build();
    }

    @Test
    public void getStudent() throws Exception{
        /*
        Student getStud = service.getStudent(student.getStud_no());
        assertEquals("Dylan", getStud.getStud_first_name());
        */
    }

    @Test
    public void saveStudent() throws Exception {
        /*
        Student getStud = StudentFactory.createStudent(student.getStud_no(),
                student.getStud_first_name(),
                student.getStud_last_name(),
                student.getStud_mark());

        service.saveStudent(getStud);
        assertEquals(88,getStud.getStud_mark());
        */

    }
}