package StudentManagementSystem.example.StudentM.repo;

import StudentManagementSystem.example.StudentM.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Long> {
    Student findByUsername(String username);
}
