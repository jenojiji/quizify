package com.quizify.question_service.service;

import com.quizify.question_service.dto.common.PageResponse;
import com.quizify.question_service.dto.question.QuestionRequest;
import com.quizify.question_service.dto.question.QuestionResponse;
import com.quizify.question_service.mapper.QuestionMapper;
import com.quizify.question_service.model.Question;
import com.quizify.question_service.repository.QuestionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;

    public PageResponse<QuestionResponse> getAllQuestions(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Question> questions = questionRepository.findAll(pageable);
        List<QuestionResponse> questionResponses = questions.stream()
                .map(questionMapper::toQuestionResponse)
                .toList();
        return new PageResponse<>(
                questionResponses,
                page,
                size,
                questions.getTotalElements(),
                questions.getTotalPages(),
                questions.isFirst(),
                questions.isLast()
        );
    }

    public QuestionResponse addQuestion(QuestionRequest request) {
        Question question = questionMapper.toQuestion(request);
        Question savedQuestion = questionRepository.save(question);
        //        QuestionResponse response=new QuestionResponse(question.getQuesDesc(), question.getOptionOne(), question.getOptionTwo(), question.getOptionThree(), question.getOptionFour(), question.getCorrectAnswer(),question.getSubject(),question.getTopic());
        return questionMapper.toQuestionResponse(savedQuestion);
    }

    public QuestionResponse getQuestionById(Integer quesId) {
        Question retrievedQuestion = questionRepository.findById(quesId)
                .orElseThrow(() -> new EntityNotFoundException("Question not found with ID:" + quesId));
        return questionMapper.toQuestionResponse(retrievedQuestion);
    }


    public PageResponse<QuestionResponse> getAllQuestionsBySubject(int page, int size, String subject) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Question> questions = questionRepository.findAllQuestionsBySubject(pageable, subject);
        List<QuestionResponse> questionResponses = questions.stream()
                .map(questionMapper::toQuestionResponse)
                .toList();
        return new PageResponse<>(
                questionResponses,
                page,
                size,
                questions.getTotalElements(),
                questions.getTotalPages(),
                questions.isFirst(),
                questions.isLast()
        );
    }

    public PageResponse<QuestionResponse> getAllQuestionsByTopic(int page, int size, String topic) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Question> questions = questionRepository.findAllQuestionsByTopic(pageable, topic);
        List<QuestionResponse> questionResponses = questions.stream()
                .map(questionMapper::toQuestionResponse)
                .toList();
        return new PageResponse<>(
                questionResponses,
                page,
                size,
                questions.getTotalElements(),
                questions.getTotalPages(),
                questions.isFirst(),
                questions.isLast()
        );
    }
}
