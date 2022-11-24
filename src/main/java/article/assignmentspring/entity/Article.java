package article.assignmentspring.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Data
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String content;

    private LocalDateTime created_at;

    private Timestamp updated_at;

    public Article() {
        created_at = LocalDateTime.now();
    }
}