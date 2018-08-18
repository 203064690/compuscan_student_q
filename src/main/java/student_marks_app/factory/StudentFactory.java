package student_marks_app.factory;

import student_marks_app.domain.Student;

public class StudentFactory {

    public static Student createStudent(String stud_no,
                                        String stud_first_name,
                                        String stud_last_name,
                                        double stud_mark)
    {
        Student student = new Student
                .Builder( stud_no )
                .stud_first_name( stud_first_name )
                .stud_last_name(stud_last_name)
                .stud_mark(stud_mark)
                .build();

        return student;
    }
}
