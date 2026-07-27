package com.cognizant.ormlearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.ormlearn.model.AttemptQuestion;

public interface AttemptQuestionRepository
        extends JpaRepository<AttemptQuestion, Integer> {

    List<AttemptQuestion> findByAttemptId(Integer attemptId);
}