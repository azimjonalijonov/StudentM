package StudentManagementSystem.example.StudentM.controller;

import StudentManagementSystem.example.StudentM.entity.Professor;
import StudentManagementSystem.example.StudentM.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProfessorController {

    @Autowired
    ProfessorService professorService;

    @PostMapping("/postProf")
    public Professor save(@RequestBody Professor professor){
        Professor res =professorService.save(professor);
        return  res;
    }

}
