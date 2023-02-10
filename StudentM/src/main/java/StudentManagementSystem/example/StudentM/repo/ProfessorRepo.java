package StudentManagementSystem.example.StudentM.repo;

import StudentManagementSystem.example.StudentM.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface ProfessorRepo extends JpaRepository<Professor,Long> {
    Professor findByUsername(String username);
}
