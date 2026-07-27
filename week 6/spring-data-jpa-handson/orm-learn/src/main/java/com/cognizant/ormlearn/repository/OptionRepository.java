package com.cognizant.ormlearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.ormlearn.model.Option;

public interface OptionRepository extends JpaRepository<Option, Integer> {

    List<Option> findByQuestionId(Integer questionId);

}