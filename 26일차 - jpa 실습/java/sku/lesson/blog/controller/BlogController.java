package sku.lesson.blog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sku.lesson.blog.domain.Article;
import sku.lesson.blog.dto.AddArticleRequest;
import sku.lesson.blog.dto.ArticleResponse;
import sku.lesson.blog.service.BlogService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @PostMapping(value="/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request){
        Article savedArticle = blogService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }

    @GetMapping(value="/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles(){
        List<ArticleResponse> articles = blogService.findAll()  // Article 도메인을 ArticleResponse dto로 변환시키는 코드
                .stream()
                .map(ArticleResponse::new)  // ArticleResponse::new : Article 객체를 인자로 받는 ArticleResponse 생성자 호출 -> 생성자 참조 (메소드, 생성자 래퍼런스)
                //.map(a -> new ArticleResponse(a))
                .toList();

        return ResponseEntity.ok()
                .body(articles);
    }
}
