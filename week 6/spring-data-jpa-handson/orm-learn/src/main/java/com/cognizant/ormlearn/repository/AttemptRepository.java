package com.cognizant.ormlearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.ormlearn.model.Attempt;

public interface AttemptRepository extends JpaRepository<Attempt, Integer> {

    List<Attempt> findByUserId(Integer userId);

}