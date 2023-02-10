package StudentManagementSystem.example.StudentM.service;

import StudentManagementSystem.example.StudentM.entity.AcademicAffairs;
import StudentManagementSystem.example.StudentM.repo.AcademicAffairsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AcademicAffairsService {
    @Autowired
    AcademicAffairsRepo academicAffairsRepo;
    @Autowired
    PasswordEncoder passwordEncoder;
    public AcademicAffairs ad(AcademicAffairs academicAffairs){
        academicAffairs.setPassword(passwordEncoder.encode(academicAffairs.getPassword()));
        return academicAffairsRepo.save(academicAffairs);
    }
}
