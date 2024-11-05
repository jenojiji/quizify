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

    /**
     * retrieve all questions as sets of specified number
     *
     * @param page
     * @param size
     * @return page response of questions
     */
    @GetMapping
    public ResponseEntity<PageResponse<QuestionResponse>> getAllQuestions(
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "10", required = false) int size
    ) {
        return ResponseEntity.ok(questionService.getAllQuestions(page, size));
    }

    /**
     * Add new question to the db
     *
     * @param request object
     * @return saved question is returned
     */
    @PostMapping("/add")
    public ResponseEntity<QuestionResponse> addQuestion(
            @RequestBody QuestionRequest request
    ) {
        return ResponseEntity.ok(questionService.addQuestion(request));
    }

    /**
     * Retrieve question by ID
     *
     * @param ques_id - unique key of question
     * @return question response object
     */
    @GetMapping("/{ques_id}")
    public ResponseEntity<QuestionResponse> getQuestionById(@PathVariable Integer ques_id) {
        return ResponseEntity.ok(questionService.getQuestionById(ques_id));
    }

    @GetMapping("/by-subject")
    public ResponseEntity<PageResponse<QuestionResponse>> getAllQuestionsBySubject(
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "10", required = false) int size,
            @RequestParam(name = "subject") String subject
    ) {
        return ResponseEntity.ok(questionService.getAllQuestionsBySubject(page, size, subject));
    }

    @GetMapping("/by-topic")
    public ResponseEntity<PageResponse<QuestionResponse>> getAllQuestionsByTopic(
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "10", required = false) int size,
            @RequestParam(name = "topic") String topic
    ) {
        return ResponseEntity.ok(questionService.getAllQuestionsByTopic(page, size, topic));
    }

    @GetMapping("/by-subject-and-topic")
    public ResponseEntity<PageResponse<QuestionResponse>> getAllQuestionsBySubjectAndTopic(
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "10", required = false) int size,
            @RequestParam(name = "subject") String subject,
            @RequestParam(name = "topic") String topic
    ) {
        return ResponseEntity.ok(questionService.getAllQuestionsBySubjectAndTopic(page, size, subject, topic));
    }


}
