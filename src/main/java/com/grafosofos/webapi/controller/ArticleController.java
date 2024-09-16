package com.grafosofos.webapi.controller;

import com.grafosofos.webapi.model.Article;
import com.grafosofos.webapi.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/api/articles")
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    @GetMapping("/api/articles/{id}")
    public Article getArticleById(@PathVariable Long id) {
        return articleService.getArticleById(id);
    }

    // Additional endpoints can be added as needed
    @PostMapping("/api/articles")
    public ResponseEntity<Article> createArticle(@RequestBody Article article) {
        Article createdArticle = articleService.saveArticle(article);
        return new ResponseEntity<>(createdArticle, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/**", method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> handleOptions() {
        log.info("Preflight request received");
        return ResponseEntity.ok()
                .header("Access-Control-Allow-Origin", "http://localhost:4200") //http://localhost:4200 https://grafosofos.com
                .header("Access-Control-Allow-Methods", "POST,GET,DELETE,PUT,OPTIONS")
                .header("Access-Control-Allow-Headers", "*")
                .header("Access-Control-Allow-Credentials", "true")
                .build();
    }
}
