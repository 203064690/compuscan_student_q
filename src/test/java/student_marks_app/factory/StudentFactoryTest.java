package student_marks_app.factory;

import org.junit.Before;
import org.junit.Test;
import student_marks_app.domain.Student;

import static org.junit.Assert.*;

public class StudentFactoryTest {
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
    public void getStudent() {
        Student getStud = StudentFactory.createStudent(student.getStud_no(),
                student.getStud_first_name(),
                student.getStud_last_name(),
                student.getStud_mark());
        assertEquals("Baadjies", getStud.getStud_last_name());
    }
}