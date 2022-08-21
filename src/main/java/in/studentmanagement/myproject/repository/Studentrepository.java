package in.studentmanagement.myproject.repository;

import in.studentmanagement.myproject.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Studentrepository extends JpaRepository<Student,Integer> {
}
