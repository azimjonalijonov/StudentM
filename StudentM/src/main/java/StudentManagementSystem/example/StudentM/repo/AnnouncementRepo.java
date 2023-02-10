package StudentManagementSystem.example.StudentM.repo;

import StudentManagementSystem.example.StudentM.entity.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnouncementRepo extends JpaRepository<Announcement,Long> {
    @Override
    List<Announcement> findAll();
}
