package StudentManagementSystem.example.StudentM.service;

import StudentManagementSystem.example.StudentM.entity.Course;
import StudentManagementSystem.example.StudentM.repo.CourseInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    @Autowired
    CourseInterface courseInterface;
    public Course addCourse(Course course){
        return courseInterface.save(course);
    }
}
