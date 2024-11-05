package com.quizify.question_service.controller;

import com.quizify.question_service.dto.common.PageResponse;
import com.quizify.question_service.dto.question.QuestionRequest;
import com.quizify.question_service.dto.question.QuestionResponse;
import com.quizify.question_service.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("questions")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping
    public ResponseEntity<PageResponse<QuestionResponse>> getAllQuestions(
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "10", required = false) int size
    ) {
        return ResponseEntity.ok(questionService.getAllQuestions(page, size));
    }

    @PostMapping("/add")
    public ResponseEntity<QuestionResponse> addQuestion(
            @RequestBody QuestionRequest request
    ) {
        return ResponseEntity.ok(questionService.addQuestion(request));
    }


}
