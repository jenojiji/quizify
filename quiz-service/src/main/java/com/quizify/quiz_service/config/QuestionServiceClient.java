package com.quizify.quiz_service.config;

import com.quizify.quiz_service.dto.common.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "QUESTION-SERVICE",url = "http://localhost:8080/api/v1/questions")
public interface QuestionServiceClient {
    @GetMapping("/limited-questions")
    public List<Question> getNQuestionsBySubjectAndTopic(
            @RequestParam(name = "subject") String subject,
            @RequestParam(name = "topic") String topic,
            @RequestParam(name = "noOfQuestions") Integer noOfQuestions
    );
}
