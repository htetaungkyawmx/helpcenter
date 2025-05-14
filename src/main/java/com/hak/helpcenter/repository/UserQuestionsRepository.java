package com.hak.helpcenter.repository;

import com.hak.helpcenter.model.UserQuestions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserQuestionsRepository extends JpaRepository<UserQuestions, Integer> {
    List<UserQuestions> findByStatus(String status);
}
