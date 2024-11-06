package com.quizify.quiz_service.dto.quiz;

import com.quizify.quiz_service.dto.common.Question;
import lombok.*;

import java.util.List;

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
    private List<Question> questions;

}
