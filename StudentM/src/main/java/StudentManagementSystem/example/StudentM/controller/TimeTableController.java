package StudentManagementSystem.example.StudentM.controller;

import StudentManagementSystem.example.StudentM.entity.TimeTable;
import StudentManagementSystem.example.StudentM.service.TimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TimeTableController {
 @Autowired
    TimeTableService timeTableService;
    @PostMapping("/table/post")
 public TimeTable post(@RequestBody TimeTable table){
        return timeTableService.save(table);
    }
    @GetMapping("/table/get/{year}")
    public List<TimeTable> get(@PathVariable Long year ){
        return timeTableService.findByYear(year);
    }
}
