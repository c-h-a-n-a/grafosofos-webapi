package com.grafosofos.webapi.controller;

import com.grafosofos.webapi.model.Article;
import com.grafosofos.webapi.repo.ArticleRepository;
import com.grafosofos.webapi.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j

public class ArticleController {

    private final ArticleService articleService;

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleController(ArticleService articleService, ArticleRepository articleRepository) {
        this.articleService = articleService;
        this.articleRepository = articleRepository;
    }


    @GetMapping("/api/articles")
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    @GetMapping("/articles")
    public ResponseEntity<Page<Article>> getArticles(Pageable pageable) {
        Page<Article> articles = articleRepository.findAll(pageable);
        return new ResponseEntity<>(articles, HttpStatus.OK);
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
