package student_marks_app.service;

import student_marks_app.domain.Student;

import java.util.List;

public interface StudentService {

    public List<Student> getAllStudent();

    public Student getStudent(String stud_no);

    public String saveStudent(Student student);

    public String updateStudent(Student student);

    public String deleteStudent(String stud_no);
}
