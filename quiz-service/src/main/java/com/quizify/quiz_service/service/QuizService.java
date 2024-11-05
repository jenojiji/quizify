package com.quizify.quiz_service.service;

import com.quizify.quiz_service.dto.common.PageResponse;
import com.quizify.quiz_service.dto.common.Question;
import com.quizify.quiz_service.dto.quiz.QuizRequest;
import com.quizify.quiz_service.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizService {

    @Value("${GET_QUESTIONS_BY_SUBJECT_AND_TOPIC}")
    String BASE_URL;
//    String BASE_URL = "http://localhost:8080/api/v1/questions/by-subject-and-topic?page=0&";

    private final QuizRepository quizRepository;
    private final RestTemplate restTemplate;


    public List<Question> createQuiz(QuizRequest request) {

        List<Question> questions = fetchQuestionsFromQuestionService(
                request.getSubject(),
                request.getTopic(),
                request.getNoOfQuestions()
        );


        return questions;
    }

    private List<Question> fetchQuestionsFromQuestionService(String subject, String topic, Integer noOfQuestions) {
        String url = BASE_URL + "subject=" + subject + "&topic=" + topic + "&noOfQuestions=" + noOfQuestions;
        PageResponse<Question> response = restTemplate.getForObject(url, PageResponse.class);
        List<Question> questions = null;
        if (response != null) {
            questions = response.getContent();
        }

        return questions;
    }
}
