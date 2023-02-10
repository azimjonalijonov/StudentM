package StudentManagementSystem.example.StudentM.controller;

import StudentManagementSystem.example.StudentM.entity.Announcement;
import StudentManagementSystem.example.StudentM.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AnnouncementController {
    @Autowired
    AnnouncementService announcementService;
    @GetMapping("/get/announce")
    public List<Announcement>  get(){
        return announcementService.get();
    }
    @PostMapping("/post/announce")
    public Announcement pos(@RequestBody Announcement announcement){
        announcement.setPostDate(new Date());
        return announcementService.save(announcement);
    }
}
