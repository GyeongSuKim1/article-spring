package article.assignmentspring;

import article.assignmentspring.entity.Article;
import article.assignmentspring.repository.ArticleRepository;
import article.assignmentspring.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class ArticleServiceTest {

    @Autowired ArticleService articleService;
    @Autowired ArticleRepository articleRepository;

    @Test
    void ArticleWrite() {
        // given
        Article articleTitle = new Article();
        articleTitle.setTitle("제목 입니다.");

        Article articleContent = new Article();
        articleContent.setContent("내용 입니다.");

        // when
        articleRepository.save(articleTitle);
        articleRepository.save(articleContent);

        // then
        System.out.println(articleTitle);
        System.out.println(articleContent);
    }
}
