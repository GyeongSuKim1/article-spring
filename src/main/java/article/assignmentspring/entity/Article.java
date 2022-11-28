package article.assignmentspring.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Data
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "제목을 입력해주세요.")
    private String title;

    @NotBlank(message = "내용을 입력해주세요.")
    private String content;

    private String created_at;

    private String updated_at;

    @PrePersist // 해당 엔티티를 저장하기 이전에 실행 된다.
    public void createdAt() {
        this.created_at = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        this.updated_at = this.created_at;
    }

    @PreUpdate  // 해당 엔티티를 업데이트 하기 이전에 실행된다
    public void updatedAt(){
        this.updated_at = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }
}