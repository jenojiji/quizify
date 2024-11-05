package com.quizify.question_service.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer quesId;
    private String quesDesc;
    private String optionOne;
    private String optionTwo;
    private String optionThree;
    private String optionFour;
    private Integer correctAnswer;
    private String subject;
    private String topic;

}
