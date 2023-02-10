package StudentManagementSystem.example.StudentM.service;

import StudentManagementSystem.example.StudentM.entity.AcademicAffairs;
import StudentManagementSystem.example.StudentM.entity.Professor;
import StudentManagementSystem.example.StudentM.entity.Student;
import StudentManagementSystem.example.StudentM.repo.AcademicAffairsRepo;
import StudentManagementSystem.example.StudentM.repo.ProfessorRepo;
import StudentManagementSystem.example.StudentM.repo.StudentRepo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;
@Component

public class SrudentDetailsService implements UserDetailsService {
    UserDetails u=null;
    private final AcademicAffairsRepo academicAffairsRepo;
    private final StudentRepo studentRepo;
    private final ProfessorRepo professorRepo;

    public SrudentDetailsService(AcademicAffairsRepo academicAffairsRepo, StudentRepo studentRepo, ProfessorRepo professorRepo) {
        this.academicAffairsRepo = academicAffairsRepo;
        this.studentRepo = studentRepo;
        this.professorRepo = professorRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {


        Student student = studentRepo.findByUsername(s);
        Professor professor=professorRepo.findByUsername(s);
        AcademicAffairs academicAffairs =academicAffairsRepo.findByUsername(s);


          if(student!=null) {

               u = new UserDetails() {
                  @Override
                  public Collection<? extends GrantedAuthority> getAuthorities() {
                      return student.getRole().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
                  }

                  @Override
                  public String getPassword() {
                      return student.getPassword();
                  }

                  @Override
                  public String getUsername() {
                      return student.getUsername();
                  }

                  @Override
                  public boolean isAccountNonExpired() {
                      return true;
                  }

                  @Override
                  public boolean isAccountNonLocked() {
                      return true;
                  }

                  @Override
                  public boolean isCredentialsNonExpired() {
                      return true;
                  }

                  @Override
                  public boolean isEnabled() {
                      return true;
                  }

              };
          }else if(professor!=null) {
               u =new UserDetails() {
                  @Override
                  public Collection<? extends GrantedAuthority> getAuthorities() {
                      return professor.getRole().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
                  }

                  @Override
                  public String getPassword() {
                      return professor.getPassword();
                  }

                  @Override
                  public String getUsername() {
                      return professor.getUsername();
                  }

                  @Override
                  public boolean isAccountNonExpired() {
                      return true;
                  }

                  @Override
                  public boolean isAccountNonLocked() {
                      return true;
                  }

                  @Override
                  public boolean isCredentialsNonExpired() {
                      return true;
                  }

                  @Override
                  public boolean isEnabled() {
                      return true;
                  }
              };

          }else {
              u =new UserDetails() {
                  @Override
                  public Collection<? extends GrantedAuthority> getAuthorities() {
                      return academicAffairs.getRole().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
                  }

                  @Override
                  public String getPassword() {
                      return academicAffairs.getPassword();
                  }

                  @Override
                  public String getUsername() {
                      return academicAffairs.getUsername();
                  }

                  @Override
                  public boolean isAccountNonExpired() {
                      return true;
                  }

                  @Override
                  public boolean isAccountNonLocked() {
                      return true;
                  }

                  @Override
                  public boolean isCredentialsNonExpired() {
                      return true;
                  }

                  @Override
                  public boolean isEnabled() {
                      return true;
                  }
              };


          }
return  u;
        }


}