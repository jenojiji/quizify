package com.quizify.question_service.repository;

import com.quizify.question_service.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    @Query("""
            SELECT question
            FROM Question question
            WHERE question.subject=:subject
            """)
    Page<Question> findAllQuestionsBySubject(Pageable pageable, String subject);

    @Query("""
            SELECT question
            FROM Question question
            WHERE question.topic=:topic
            """)
    Page<Question> findAllQuestionsByTopic(Pageable pageable, String topic);
}
