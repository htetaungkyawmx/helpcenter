package com.hak.helpcenter.repository;

import com.hak.helpcenter.model.UserQuestions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserQuestionsRepository extends JpaRepository<UserQuestions,Integer> {

}
