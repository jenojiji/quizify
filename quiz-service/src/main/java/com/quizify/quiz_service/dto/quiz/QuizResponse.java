package com.quizify.quiz_service.dto.quiz;

import lombok.*;

import java.util.List;
import java.util.Map;

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
    private List<Integer> questionIds;
    private List<Map<String, Object>> questions;

}
