package com.quizify.question_service.repository;

import com.quizify.question_service.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

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

    @Query("""
            SELECT question
            FROM Question question
            WHERE question.subject=:subject
            AND question.topic=:topic
            """)
    Page<Question> findAllQuestionsBySubjectAndTopic(Pageable pageable, String subject, String topic);

    @Query(value = "SELECT * FROM Question question WHERE question.subject = ?1 AND question.topic = ?2 LIMIT ?3", nativeQuery = true)
    Optional<List<Question>> findSpecificNoOfQuestions(String subject, String topic, int limit);
}
