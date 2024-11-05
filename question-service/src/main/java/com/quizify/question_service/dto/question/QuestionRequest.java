package com.quizify.question_service.dto.question;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionRequest {

    private String quesDesc;
    private String optionOne;
    private String optionTwo;
    private String optionThree;
    private String optionFour;
    private Integer correctAnswer;
    private String subject;
    private String topic;

}
