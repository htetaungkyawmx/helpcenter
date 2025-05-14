package com.hak.helpcenter.service;

import com.hak.helpcenter.dto.helpcenter.FrequentQuestionsDto;

import java.util.List;

public interface IFrequentQuestionsService {
    String createFrequentQuestion(FrequentQuestionsDto form);
    String updateFrequentQuestions(int questionId, FrequentQuestionsDto form);
    FrequentQuestionsDto getFrequentQuestionById(int questionId);
    String deleteFrequentQuestion(int questionId);
    List<FrequentQuestionsDto> getAllFrequentQuestions();
    List<FrequentQuestionsDto> getFeaturedFrequentQuestions();
    List<FrequentQuestionsDto> getFrequentQuestionsByCategory(String category);
}
