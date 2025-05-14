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
                .category(dto.getCategory())
                .question(dto.getQuestion())
                .answer(dto.getAnswer())
                .viewCount(dto.getViewCount())
                .isFeatured(dto.getIsFeatured())
                .build();
    }

    public FrequentQuestionsDto toDto(FrequentQuestions entity) {
        return FrequentQuestionsDto.builder()
                .questionId(entity.getQuestionId())
                .questionCode(entity.getQuestionCode())
                .category(entity.getCategory())
                .question(entity.getQuestion())
                .answer(entity.getAnswer())
                .viewCount(entity.getViewCount())
                .isFeatured(entity.getIsFeatured())
                .build();
    }

    public FrequentQuestions updateEntity(FrequentQuestions entity, FrequentQuestionsDto dto) {
        entity.setQuestionCode(dto.getQuestionCode());
        entity.setCategory(dto.getCategory());
        entity.setQuestion(dto.getQuestion());
        entity.setAnswer(dto.getAnswer());
        entity.setViewCount(dto.getViewCount());
        entity.setIsFeatured(dto.getIsFeatured());
        return entity;
    }
}
