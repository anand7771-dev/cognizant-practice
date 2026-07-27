package com.cognizant.ormlearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.ormlearn.model.AttemptOption;

public interface AttemptOptionRepository
        extends JpaRepository<AttemptOption, Integer> {

    List<AttemptOption> findByAttemptQuestionIdAndSelectedTrue(
            Integer attemptQuestionId);
}