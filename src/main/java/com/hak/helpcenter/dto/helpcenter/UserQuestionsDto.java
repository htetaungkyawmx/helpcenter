package com.hak.helpcenter.dto.helpcenter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserQuestionsDto {

    private Integer questionId;
    private Integer questionCode;
    private String subject;
    private String question;
    private String answerEmail;
}
