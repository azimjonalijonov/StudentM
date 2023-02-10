package StudentManagementSystem.example.StudentM.controller;

import StudentManagementSystem.example.StudentM.entity.Course;
import StudentManagementSystem.example.StudentM.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CourseController {
    @Autowired
    CourseService courseService;
    @PostMapping("/addCourse")
    public Course add(@RequestBody Course course){
        return courseService.addCourse(course);

    }

}
