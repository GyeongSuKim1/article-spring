package article.assignmentspring.repository;

import article.assignmentspring.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // JpaRepository를 상속받고 제네릭안에 <Entity, PK의 TYPE>을 입력
public interface ArticleRepository
        extends JpaRepository<Article, Integer> {
}