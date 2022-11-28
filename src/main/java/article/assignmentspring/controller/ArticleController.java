package article.assignmentspring.controller;

import article.assignmentspring.entity.Article;
import article.assignmentspring.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    // 게시글 작성 페이지
    @GetMapping("/article/write")
    public String articleWriteForm() {

        return "articleLite";   // 어떤 HTML파일로 보내줄지 입력
    }

    // 게시글 작성 페이지
    @PostMapping("/article/writepro")
    // entity에서 @Data를 해주었기 때문에 엔티티 형식을 그대로 받아줄 수 있음.
    public String articlePro(Article article) {
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        System.out.println("Id : " + article.getId());
        System.out.println("Title : " + article.getTitle());
        System.out.println("Content : " + article.getContent());
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        System.out.println("Created_at : " + article.getCreated_at());
        System.out.println("Updated_at : " + article.getUpdated_at());
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

        articleService.articleWrite(article);
        return "redirect:/article/list";
    }

    // 게시글 페이지
    @GetMapping("/article/list")
    public String articleList(Model model) {

        // list라는 이름으로 받아서 넘김
        model.addAttribute("list" ,articleService.articleList());
        return "articleList";
    }

    // 게시글 상세페이지
        // 값을 넘겨줄때는 매개변수에 Model을 선언해줘야 함
    @GetMapping("/article/view")
    public String articleView(Model model, Integer id) {

        model.addAttribute("article", articleService.articleView(id));
        return "articleView";
    }

    // 게시글 삭제
    @GetMapping("/article/delete")
    public String articleDelete(Integer id) {

        articleService.articleDelete(id);
        return "redirect:/article/list";
    }

    // 게시글 수정 GET
    @GetMapping("/article/modify/{id}")
    public String articleModify(@PathVariable("id") Integer id,
                                Model model) {

        // 페이지로 넘어올때 Title과 Content에 담긴 데이터를 꺼내와야
        // 때문에 articleView로 데이터를 가져옴
        model.addAttribute("article", articleService.articleView(id));
        return "articleModify";
    }

    // 게시글 수정 POST
    @PostMapping( "/article/update/{id}")
    public String articleUpdate(@PathVariable("id") Integer id,
                                Article article) {

        // 데이터를 꺼내온후
        Article articleTemp = articleService.articleView(id);

        // 기존 데이터에 새 데이터를 넣어줌
        articleTemp.setTitle(article.getTitle());
        articleTemp.setContent(article.getContent());

        // 저장
        articleService.articleWrite(articleTemp);

        return "redirect:/article/view?id={id}";
    }
}