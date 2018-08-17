package student_marks_app.factory;

import student_marks_app.domain.Student;

public class StudentFactory {

    public static Student createStudent(String stud_no,
                                        String stud_firstName,
                                        String stud_lastName,
                                        double stud_mark)
    {
        Student student = new Student
                .Builder( stud_no )
                .stud_firstName( stud_firstName )
                .stud_lastName(stud_lastName)
                .stud_mark(stud_mark)
                .build();

        return student;
    }
}
