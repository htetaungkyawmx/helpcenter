package com.hak.helpcenter.mapper;

import com.hak.helpcenter.dto.helpcenter.FrequentQuestionsDto;
import com.hak.helpcenter.model.FrequentQuestions;
import org.springframework.stereotype.Component;

@Component
public class FrequentQuestionsMapper {

    public FrequentQuestions toEntity(FrequentQuestionsDto dto) {
        return FrequentQuestions.builder()
                .questionId(dto.getQuestionId())
                .questionCode(dto.getQuestionCode())
                .question(dto.getQuestion())
                .answer(dto.getAnswer())
                .build();
    }

    public FrequentQuestionsDto toDto(FrequentQuestions entity) {
        return FrequentQuestionsDto.builder()
                .questionId(entity.getQuestionId())
                .questionCode(entity.getQuestionCode())
                .question(entity.getQuestion())
                .answer(entity.getAnswer())
                .build();
    }

    public FrequentQuestions updateEntity(FrequentQuestions entity, FrequentQuestionsDto dto) {
        entity.setQuestionCode(dto.getQuestionCode());
        entity.setQuestion(dto.getQuestion());
        entity.setAnswer(dto.getAnswer());
        return entity;
    }
}