package StudentManagementSystem.example.StudentM.entity;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
@Entity
public class Course implements Serializable {
    @Id
    @NotNull
    private String name;
    public String getName(){return name;}
    public void setName(String name){this.name=name;}

}
