package com.quizify.quiz_service.service;

import com.quizify.quiz_service.config.QuestionServiceClient;
import com.quizify.quiz_service.dto.common.Question;
import com.quizify.quiz_service.dto.quiz.QuizRequest;
import com.quizify.quiz_service.dto.quiz.QuizResponse;
import com.quizify.quiz_service.model.Quiz;
import com.quizify.quiz_service.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuizService {

    @Value("${GET_QUESTIONS_BY_SUBJECT_AND_TOPIC}")
    String BASE_URL;

    private final QuizRepository quizRepository;
    private final RestTemplate restTemplate;
    @Autowired
    QuestionServiceClient questionServiceClient;


    public QuizResponse createQuiz(QuizRequest request) {

//        List<Map<String, Object>> questions = fetchQuestionsFromQuestionService(
//                request.getSubject(),
//                request.getTopic(),
//                request.getNoOfQuestions()
//        );

        List<Question> questions = questionServiceClient.getNQuestionsBySubjectAndTopic(request.getSubject(),
                request.getTopic(),
                request.getNoOfQuestions());


        List<Integer> quesIdsList = questions.stream()
                .map(Question::getQuesId)
                .collect(Collectors.toList());


        Quiz newQuiz = Quiz.builder()
                .title(request.getTitle())
                .instructions(request.getInstructions())
                .totalQuestions(request.getTotalQuestions())
                .markPerQuestion(request.getMarkPerQuestion())
                .subject(request.getSubject())
                .topic(request.getTopic())
                .questionIds(quesIdsList)
                .build();
        Quiz savedQuiz = quizRepository.save(newQuiz);
        return QuizResponse.builder()
                .title(request.getTitle())
                .instructions(request.getInstructions())
                .totalQuestions(request.getTotalQuestions())
                .markPerQuestion(request.getMarkPerQuestion())
                .subject(request.getSubject())
                .topic(request.getTopic())
                .questionIds(quesIdsList)
                .questions(questions)
                .build();
    }

    private List<Map<String, Object>> fetchQuestionsFromQuestionService(String subject, String topic, Integer noOfQuestions) {
        String url = BASE_URL + "subject=" + subject + "&topic=" + topic + "&noOfQuestions=" + noOfQuestions;
        List<Map<String, Object>> questions = restTemplate.getForObject(url, List.class);
        return questions;
    }
}
