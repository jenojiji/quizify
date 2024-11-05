package com.quizify.quiz_service.dto.quiz;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuizResponse {
    private String title;
    private String instructions;
    private Integer totalQuestions;
    private Integer markPerQuestion;

    private String subject;
    private String topic;


}
