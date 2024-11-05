package com.quizify.quiz_service.dto.common;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question {
    private String quesDesc;
    private String optionOne;
    private String optionTwo;
    private String optionThree;
    private String optionFour;
    private Integer correctAnswer;
    private String subject;
    private String topic;

}
