package com.hak.helpcenter.service;

import com.hak.helpcenter.dto.helpcenter.FrequentQuestionsDto;

public interface IFrequentQuestionsService {
    String createFrequentQuestion(FrequentQuestionsDto form);
    String updateFrequentQuestions(int questionId, FrequentQuestionsDto form);
    FrequentQuestionsDto getFrequentQuestionById(int questionId);
    String deleteFrequentQuestion(int questionId);
}