package student_marks_app.repository;

import org.springframework.data.repository.CrudRepository;
import student_marks_app.domain.Student;

public interface StudentRepo extends CrudRepository<Student, Long> {
}
