package com.quizify.quiz_service.dto.quiz;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Builder
public class QuizRequest {
    private String title;
    private String instructions;
    private Integer totalQuestions;
    private Integer markPerQuestion;

    private String subject;
    private String topic;
    private Integer noOfQuestions;
}
