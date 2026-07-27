package com.cognizant.ormlearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ormlearn.model.Attempt;
import com.cognizant.ormlearn.model.AttemptOption;
import com.cognizant.ormlearn.model.AttemptQuestion;
import com.cognizant.ormlearn.repository.AttemptOptionRepository;
import com.cognizant.ormlearn.repository.AttemptQuestionRepository;
import com.cognizant.ormlearn.repository.AttemptRepository;

@Service
public class AttemptService {

    @Autowired
    private AttemptRepository attemptRepository;

    @Autowired
    private AttemptQuestionRepository attemptQuestionRepository;

    @Autowired
    private AttemptOptionRepository attemptOptionRepository;

    @Transactional(readOnly = true)
    public Attempt getAttempt(Integer attemptId) {
        return attemptRepository.findById(attemptId).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<AttemptQuestion> getAttemptQuestions(Integer attemptId) {
        return attemptQuestionRepository.findByAttemptId(attemptId);
    }

    @Transactional(readOnly = true)
    public List<AttemptOption> getSelectedOptions(Integer attemptQuestionId) {
        return attemptOptionRepository
                .findByAttemptQuestionIdAndSelectedTrue(attemptQuestionId);
    }
}