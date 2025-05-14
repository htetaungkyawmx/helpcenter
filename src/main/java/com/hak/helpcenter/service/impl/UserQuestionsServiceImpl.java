package com.hak.helpcenter.service.impl;

import com.hak.helpcenter.dto.helpcenter.UserQuestionsDto;
import com.hak.helpcenter.mapper.UserQuestionsMapper;
import com.hak.helpcenter.model.UserQuestions;
import com.hak.helpcenter.repository.UserQuestionsRepository;
import com.hak.helpcenter.service.IUserQuestionsService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
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
    @Transactional(readOnly = true)
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

    @Override
    @Transactional(readOnly = true)
    public List<UserQuestionsDto> getAllUserQuestions() {
        List<UserQuestions> questions = userQuestionsRepository.findAll();
        return questions.stream()
                .map(userQuestionsMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserQuestionsDto> getUserQuestionsByStatus(String status) {
        List<UserQuestions> questions = userQuestionsRepository.findByStatus(status);
        return questions.stream()
                .map(userQuestionsMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public String answerUserQuestion(int questionId, String answer) {
        UserQuestions question = userQuestionsRepository.findById(questionId)
                .orElseThrow(() -> new EntityNotFoundException("User question not found with id " + questionId));

        question.setAnswer(answer);
        question.setStatus("ANSWERED");
        userQuestionsRepository.save(question);

        return "Question ID: " + questionId + " has been answered successfully.";
    }
}
