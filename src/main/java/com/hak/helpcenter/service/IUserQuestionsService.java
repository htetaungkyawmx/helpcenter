package com.hak.helpcenter.service;

import com.hak.helpcenter.dto.helpcenter.UserQuestionsDto;

import java.util.List;

public interface IUserQuestionsService {
    String createUserQuestion(UserQuestionsDto form);
    String updateUserQuestions(int questionId, UserQuestionsDto form);
    UserQuestionsDto fetchUserQuestionsDetailsById(int questionId);
    String deleteUserQuestions(int questionId);
    List<UserQuestionsDto> getAllUserQuestions();
    List<UserQuestionsDto> getUserQuestionsByStatus(String status);
    String answerUserQuestion(int questionId, String answer);
}
