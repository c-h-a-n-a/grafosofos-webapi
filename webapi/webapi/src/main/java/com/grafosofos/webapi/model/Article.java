package com.grafosofos.webapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Entity
@Table(name = "articles")
public class Article {

    @Id
    @Column(name = "article_id")
    private int articleId;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "author")
    private String author;

    @Column(name = "description")
    private String description;

    @Column(name = "date_created")
    private LocalDateTime date;

    public void setDateCreated(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.date = LocalDateTime.parse(date, formatter);
    }


}
