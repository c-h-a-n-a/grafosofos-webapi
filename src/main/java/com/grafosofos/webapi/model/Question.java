package com.grafosofos.webapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "questions")
public class Question {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "lesson")
    private String lesson;
    @Column(name = "question_text")
    private String questionText;
    @Column(name = "correct_answer")
    private String correctAnswer;
    @Column(name = "type")
    private String type; // "multiple-choice" or "true-false"

    @Column(columnDefinition = "json")
    private String options; // Store options as a JSON string


    // New field to hold the parsed options
    @Transient
    private List<String> optionsList;

}
