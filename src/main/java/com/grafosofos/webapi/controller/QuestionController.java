package com.grafosofos.webapi.controller;

import com.grafosofos.webapi.model.Question;
import com.grafosofos.webapi.repo.QuestionRepository;
import com.grafosofos.webapi.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
@Slf4j
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/{lesson}")
    public List<Question> getQuestionsByLesson(@PathVariable String lesson) {
        return questionService.getQuestionsByLesson(lesson);
    }

    @GetMapping("/")
    public List<Question> getALL() {
        return questionService.getAll();
    }
}
