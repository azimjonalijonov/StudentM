package StudentManagementSystem.example.StudentM.service;

import StudentManagementSystem.example.StudentM.entity.Announcement;
import StudentManagementSystem.example.StudentM.repo.AnnouncementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementService {
    @Autowired
    AnnouncementRepo announcementRepo;
    public Announcement save(Announcement announcement){
        return announcementRepo.save(announcement);
    }
    public List<Announcement> get(){
        return announcementRepo.findAll();

    }
}
