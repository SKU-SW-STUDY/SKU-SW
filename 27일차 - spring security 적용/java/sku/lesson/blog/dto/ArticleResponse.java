package sku.lesson.blog.dto;

import lombok.Getter;
import sku.lesson.blog.domain.Article;

@Getter
public class ArticleResponse {

    private String title;

    private String content;


    /* 응답 변환 */
    public ArticleResponse(Article article){
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
