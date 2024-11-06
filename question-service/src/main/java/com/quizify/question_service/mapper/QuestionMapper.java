package com.quizify.question_service.mapper;

import com.quizify.question_service.dto.question.QuestionRequest;
import com.quizify.question_service.dto.question.QuestionResponse;
import com.quizify.question_service.model.Question;
import lombok.Builder;
import org.springframework.stereotype.Service;

@Service
@Builder
public class QuestionMapper {

    public QuestionResponse toQuestionResponse(Question question) {
        return QuestionResponse.builder()
                .quesId(question.getQuesId())
                .quesDesc(question.getQuesDesc())
                .optionOne(question.getOptionOne())
                .optionTwo(question.getOptionTwo())
                .optionThree(question.getOptionThree())
                .optionFour(question.getOptionFour())
                .correctAnswer(question.getCorrectAnswer())
                .subject(question.getSubject())
                .topic(question.getTopic())
                .build();
    }

    public Question toQuestion(QuestionRequest request) {
        return Question.builder()
                .quesDesc(request.getQuesDesc())
                .optionOne(request.getOptionOne())
                .optionTwo(request.getOptionTwo())
                .optionThree(request.getOptionThree())
                .optionFour(request.getOptionFour())
                .correctAnswer(request.getCorrectAnswer())
                .subject(request.getSubject())
                .topic(request.getTopic())
                .build();
    }
}
