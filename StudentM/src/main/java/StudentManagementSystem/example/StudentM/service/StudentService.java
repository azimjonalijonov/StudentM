package StudentManagementSystem.example.StudentM.service;

import StudentManagementSystem.example.StudentM.entity.Student;
import StudentManagementSystem.example.StudentM.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;
    @Autowired
    PasswordEncoder passwordEncoder;
    public  List<Student> getAllStudents(){
        List<Student> st =studentRepo.findAll();
        return st;
    }

    public Student saveStudent(Student student){
     student.setPassword(passwordEncoder.encode(student.getPassword()));
        return  studentRepo.save(student);
    }

    public  Student getStudentById(Long id){

      return studentRepo.findById(id).get();
    }

    public Student updateStudent(Student student){
        return studentRepo.save(student);
    }

    public  void deleteStudentById(Long id){
        studentRepo.deleteById(id);
        System.out.println("Student uchirildi");
    }
}
