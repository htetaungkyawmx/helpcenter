package com.hak.helpcenter.repository;

import com.hak.helpcenter.model.FrequentQuestions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrequentQuestionsRepository extends JpaRepository<FrequentQuestions, Integer> {

}