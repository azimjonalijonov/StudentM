package StudentManagementSystem.example.StudentM.entity;

import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Announcement implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private Date postDate;
    @Column(length = 10000, nullable = false)
    private String body;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
