package StudentManagementSystem.example.StudentM.controller;

import StudentManagementSystem.example.StudentM.entity.Student;
import StudentManagementSystem.example.StudentM.service.StudentService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class StudentController {
private final StudentService studentService;

    public StudentController(StudentService studentService) {

        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> listStudents( ) {

       List<Student> st= studentService.getAllStudents();
       return st;

    }


    @PostMapping("/students/post")
    public Student saveStudent(@RequestBody Student student) {
        Student save = studentService.  saveStudent(student);
        return save;

    }

//    @GetMapping("/students/edit/{id}")
//    public Student getStudentByIdd(@PathVariable Long id) {
//        Student s =studentService.getStudentById(id);
//        return s;
//    }

    @PutMapping("/students/edit/{id}")
    public Student updateStudent(@PathVariable Long id,
                                @RequestBody Student student
                                ) {

        Student existingStudent = studentService.getStudentById(id);

        existingStudent.setId(id);
        if(student.getFirstName()!=null){
        existingStudent.setFirstName(student.getFirstName());}
        if(student.getLastName()!=null){
        existingStudent.setLastName(student.getLastName());}
       if(student.getEmail()!=null) {
           existingStudent.setEmail(student.getEmail());
       }
         return  studentService.updateStudent(existingStudent);

    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);

    }
}
