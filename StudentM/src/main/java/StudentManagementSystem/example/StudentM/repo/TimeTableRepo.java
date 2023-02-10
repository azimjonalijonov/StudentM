package StudentManagementSystem.example.StudentM.repo;

import StudentManagementSystem.example.StudentM.entity.TimeTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeTableRepo extends JpaRepository<TimeTable,Long> {

    List<TimeTable> findByYear(Long year);
}
