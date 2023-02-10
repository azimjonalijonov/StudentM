package StudentManagementSystem.example.StudentM.service;

import StudentManagementSystem.example.StudentM.entity.Professor;
import StudentManagementSystem.example.StudentM.repo.ProfessorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {
    @Autowired
    ProfessorRepo professorRepo;
    @Autowired
    PasswordEncoder passwordEncoder;
    public Professor save(Professor professor){
        professor.setPassword(passwordEncoder.encode(professor.getPassword()));
        return professorRepo.save(professor);
    }
}
