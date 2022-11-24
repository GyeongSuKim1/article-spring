package article.assignmentspring.service;

import article.assignmentspring.entity.Article;
import article.assignmentspring.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    // Spring의 @Autowired를 사용하여 필요한 의존 객체를 빈에 주입해준다.
    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    // 게시글 작성 처리
        // 매개변수 안에 Article이라는 클래스의 article변수로 반환하여 save에 담아준다.
    public void articleWrite(Article article) {

        articleRepository.save(article);
    }

    // 게시글 리스트 처리
        // Article이라는 class가 담긴 List를 반환해준다는 뜻.
    public List<Article> articleList() {

        return articleRepository.findAll();
    }

    // 특정 게시글 불러오기
    public Article articleView(Integer id) {

        return articleRepository.findById(id).get();
    }

    // 게시글 삭제
    public void articleDelete (Integer id) {

        articleRepository.deleteById(id);
    }

    // 게시글 수정
    public void articleModify(Integer id) {

    articleRepository.findById(id);

    }
}