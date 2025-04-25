package com.hak.helpcenter.service.impl;

import com.hak.helpcenter.dto.helpcenter.UserQuestionsDto;
import com.hak.helpcenter.mapper.UserQuestionsMapper;
import com.hak.helpcenter.model.UserQuestions;
import com.hak.helpcenter.repository.UserQuestionsRepository;
import com.hak.helpcenter.service.IUserQuestionsService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserQuestionsServiceImpl implements IUserQuestionsService {

    private final UserQuestionsRepository userQuestionsRepository;
    private final UserQuestionsMapper userQuestionsMapper;

    @Override
    public String createUserQuestion(UserQuestionsDto form) {
        UserQuestions entity = userQuestionsMapper.toEntity(form);
        UserQuestions savedEntity = userQuestionsRepository.save(entity);
        return "User question: " + savedEntity.getQuestion() + " saved successfully.";
    }

    @Override
    public String updateUserQuestions(int questionId, UserQuestionsDto form) {
        UserQuestions existingEntity = userQuestionsRepository.findById(questionId)
                .orElseThrow(() -> new EntityNotFoundException("User question not found with id " + questionId));

        UserQuestions updatedEntity = userQuestionsMapper.updateEntity(existingEntity, form);
        userQuestionsRepository.save(updatedEntity);
        return "User question: " + updatedEntity.getQuestion() + " updated successfully.";
    }

    @Override
    public UserQuestionsDto fetchUserQuestionsDetailsById(int questionId) {
        UserQuestions entity = userQuestionsRepository.findById(questionId)
                .orElseThrow(() -> new EntityNotFoundException("User question not found with id " + questionId));
        return userQuestionsMapper.toDto(entity);
    }

    @Override
    public String deleteUserQuestions(int questionId) {
        UserQuestions entity = userQuestionsRepository.findById(questionId)
                .orElseThrow(() -> new EntityNotFoundException("User question not found with id " + questionId));
        userQuestionsRepository.delete(entity);
        return "User question with ID: " + questionId + " deleted successfully.";
    }
}