package sku.lesson.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sku.lesson.blog.domain.Article;

public interface BlogRepository extends JpaRepository<Article, Long> {

}
