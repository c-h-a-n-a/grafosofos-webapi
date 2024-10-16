package com.grafosofos.webapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grafosofos.webapi.model.Question;
import com.grafosofos.webapi.repo.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> getQuestionsByLesson(String lesson) {
        List<Question> questions = questionRepository.findByLesson(lesson);
        for (Question question : questions) {
            // Convert JSON string to List<String>
            try {
                List<String> optionsList = objectMapper.readValue(question.getOptions(), List.class);
                question.setOptionsList(optionsList); // Add this method to your Question class
            } catch (Exception e) {
                e.printStackTrace(); // Handle exception
            }
        }
        return questions;
    }

    public List<Question> getAll(){
        return questionRepository.findAll();
    }
}
