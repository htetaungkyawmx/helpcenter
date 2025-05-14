package com.hak.helpcenter.repository;

import com.hak.helpcenter.model.FrequentQuestions;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FrequentQuestionsRepository extends JpaRepository<FrequentQuestions, Integer> {
    List<FrequentQuestions> findByIsFeaturedTrue();
    List<FrequentQuestions> findByCategory(String category);
}
