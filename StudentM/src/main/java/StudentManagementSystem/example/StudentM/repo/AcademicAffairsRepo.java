package StudentManagementSystem.example.StudentM.repo;

import StudentManagementSystem.example.StudentM.entity.AcademicAffairs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademicAffairsRepo extends JpaRepository<AcademicAffairs,Long> {
AcademicAffairs findByUsername(String username);
}
