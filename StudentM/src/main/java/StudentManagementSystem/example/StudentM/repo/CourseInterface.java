package StudentManagementSystem.example.StudentM.repo;

import StudentManagementSystem.example.StudentM.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface CourseInterface extends JpaRepository<Course,String> {
}
