package com.hak.helpcenter.mapper;

import com.hak.helpcenter.dto.helpcenter.UserQuestionsDto;
import com.hak.helpcenter.model.UserQuestions;
import org.springframework.stereotype.Component;

@Component
public class UserQuestionsMapper {
    public UserQuestions toEntity(UserQuestionsDto dto) {
        return UserQuestions.builder()
                .questionId(dto.getQuestionId())
                .name(dto.getName())
                .email(dto.getEmail())
                .selectDate(dto.getSelectDate())
                .topic(dto.getTopic())
                .subject(dto.getSubject())
                .question(dto.getQuestion())
                .status(dto.getStatus())
                .answer(dto.getAnswer())
                .build();
    }

    public UserQuestionsDto toDto(UserQuestions entity) {
        return UserQuestionsDto.builder()
                .questionId(entity.getQuestionId())
                .name(entity.getName())
                .email(entity.getEmail())
                .selectDate(entity.getSelectDate())
                .topic(entity.getTopic())
                .subject(entity.getSubject())
                .question(entity.getQuestion())
                .status(entity.getStatus())
                .answer(entity.getAnswer())
                .build();
    }

    public UserQuestions updateEntity(UserQuestions entity, UserQuestionsDto dto) {
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setSelectDate(dto.getSelectDate());
        entity.setTopic(dto.getTopic());
        entity.setSubject(dto.getSubject());
        entity.setQuestion(dto.getQuestion());
        entity.setStatus(dto.getStatus());
        entity.setAnswer(dto.getAnswer());
        return entity;
    }
}
