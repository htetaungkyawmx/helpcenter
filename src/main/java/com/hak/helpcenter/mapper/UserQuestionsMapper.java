package com.hak.helpcenter.mapper;

import com.hak.helpcenter.dto.helpcenter.UserQuestionsDto;
import com.hak.helpcenter.model.UserQuestions;
import org.springframework.stereotype.Component;

@Component
public class UserQuestionsMapper {

    public UserQuestions toEntity(UserQuestionsDto dto) {
        return UserQuestions.builder()
                .questionId(dto.getQuestionId())
                .questionCode(dto.getQuestionCode())
                .subject(dto.getSubject())
                .question(dto.getQuestion())
                .answerEmail(dto.getAnswerEmail())
                .build();
    }

    public UserQuestionsDto toDto(UserQuestions entity) {
        return UserQuestionsDto.builder()
                .questionId(entity.getQuestionId())
                .questionCode(entity.getQuestionCode())
                .subject(entity.getSubject())
                .question(entity.getQuestion())
                .answerEmail(entity.getAnswerEmail())
                .build();
    }

    public UserQuestions updateEntity(UserQuestions entity, UserQuestionsDto dto) {
        entity.setQuestionCode(dto.getQuestionCode());
        entity.setSubject(dto.getSubject());
        entity.setQuestion(dto.getQuestion());
        entity.setAnswerEmail(dto.getAnswerEmail());
        return entity;
    }
}