package StudentManagementSystem.example.StudentM.config;

import StudentManagementSystem.example.StudentM.service.ProfessorDetailsService;
import StudentManagementSystem.example.StudentM.service.SrudentDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class Security extends WebSecurityConfigurerAdapter {

//    private  final UserDetailsService userDetailsService;
//
//    public Security( @Lazy UserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }
    private  final SrudentDetailsService srudentDetailsService;

    public Security(SrudentDetailsService srudentDetailsService, ProfessorDetailsService professorDetailsService) {
        this.srudentDetailsService = srudentDetailsService;
        this.professorDetailsService = professorDetailsService;
    }
    private  final ProfessorDetailsService professorDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.
                userDetailsService(srudentDetailsService).passwordEncoder(passwordEncoder());

    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
http.csrf().disable()
       .headers().frameOptions().disable()
                .and()

                . authorizeRequests()
             .antMatchers("/api/students").hasAnyRole("Student","Affairs","Professor")
             .antMatchers("/api/table/get/{year}").hasAnyRole("Student","Professor","Affairs")
                .antMatchers("/api/students/post").hasRole("Affairs")
              .antMatchers("/api/postProf").hasRole("Affairs")
                .antMatchers("/api/addCourse").hasRole("Professor")
                .antMatchers("/api/students/edit/**").hasRole("Affairs")
                .antMatchers("/api//students/{id}").hasRole("Professor")
                .antMatchers("/api/table/post").hasRole("Affairs")
                .antMatchers("/api/get/announce").permitAll()
                .antMatchers("/api/table/get/{year}").permitAll()
              //  .antMatchers("/api/post/affairs").permitAll()
                .antMatchers("/api/post/announce").hasRole("Affairs")
                .anyRequest().
                authenticated()
                .and()
                .httpBasic();
    }

    @Bean
    PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    }
}
