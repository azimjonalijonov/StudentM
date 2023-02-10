package StudentManagementSystem.example.StudentM.service;

import StudentManagementSystem.example.StudentM.entity.Professor;
import StudentManagementSystem.example.StudentM.repo.ProfessorRepo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class ProfessorDetailsService implements UserDetailsService {

  private final ProfessorRepo professorRepo;

    public ProfessorDetailsService(ProfessorRepo professorRepo) {
        this.professorRepo = professorRepo;
    }

    @Override
        public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

            Professor professor = professorRepo.findByUsername(s);
            return new UserDetails() {
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

        }
    }