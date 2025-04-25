package com.hak.helpcenter.service;

import com.hak.helpcenter.dto.helpcenter.UserQuestionsDto;

public interface IUserQuestionsService {
    String createUserQuestion(UserQuestionsDto form);
    String updateUserQuestions(int questionId, UserQuestionsDto form);
    UserQuestionsDto fetchUserQuestionsDetailsById(int questionId);
    String deleteUserQuestions(int questionId);
}