package com.quizify.quiz_service.controller;

import com.quizify.quiz_service.dto.quiz.QuizRequest;
import com.quizify.quiz_service.dto.quiz.QuizResponse;
import com.quizify.quiz_service.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("quizzes")
@RequiredArgsConstructor
public class QuizController {
    private final QuizService quizService;

    @PostMapping
    public ResponseEntity<QuizResponse> createQuiz(
            @RequestBody QuizRequest request
    ) {
        return ResponseEntity.ok(quizService.createQuiz(request));
    }

}
