package StudentManagementSystem.example.StudentM.controller;

import StudentManagementSystem.example.StudentM.entity.AcademicAffairs;
import StudentManagementSystem.example.StudentM.service.AcademicAffairsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AcademicController {
    @Autowired
    AcademicAffairsService academicAffairsService;
    @PostMapping("/post/affairs")
    public AcademicAffairs post(@RequestBody AcademicAffairs academicAffairs){
        return academicAffairsService.ad(academicAffairs);
    }
}
