package com.hak.helpcenter.repository;

import com.hak.helpcenter.model.QuestionInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionInfoRepository extends JpaRepository<QuestionInfo,Integer> {

}
