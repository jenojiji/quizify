package com.quizify.quiz_service.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "quiz")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer quiz_id;

    private String title;
    private String instructions;
    private Integer totalQuestions;
    private Integer markPerQuestion;

    private String subject;
    private String topic;

    private List<Integer> questionIds;

}
