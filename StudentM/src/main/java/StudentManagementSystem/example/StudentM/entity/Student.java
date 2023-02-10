package StudentManagementSystem.example.StudentM.entity;

import StudentManagementSystem.example.StudentM.entity.enumuration.Status;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
    @Table(name = "students")
    public class Student implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @NotNull

        private String username;
        @NotNull
        private String password;
        private Status status =Status.Student;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Column(name = "first_name", nullable = false)
        private String firstName;

        @Column(name = "last_name")
        private String lastName;

        @Column(name = "email")
        private String email;

        @ManyToMany(fetch=FetchType.EAGER)
        @JoinTable (
                name = "student_role",
                joinColumns ={@JoinColumn(name = "student_id",referencedColumnName = "id")},
                inverseJoinColumns = {@JoinColumn(name = "role_name", referencedColumnName = "name")}
        )
        private Set<Role> role =new HashSet<>();
        @ManyToMany(fetch=FetchType.EAGER)
        @JoinTable (
                name = "student_course",
                joinColumns ={@JoinColumn(name = "student_id",referencedColumnName = "id")},
                inverseJoinColumns = {@JoinColumn(name = "course_name", referencedColumnName = "name")}
        )
        private Set<Course> courses =new HashSet<>();
        public Student() {

        }


    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Student(Long id, String firstName, String lastName, String email, Role role, Set<Course> courses) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

        this.courses = courses;
    }

    public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }
        public String getFirstName() {
            return firstName;
        }
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
        public String getLastName() {
            return lastName;
        }
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

