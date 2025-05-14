package com.hak.helpcenter.dto.helpcenter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class UserQuestionsDto {
    private Integer questionId;
    private String name;
    private String email;
    private LocalDate selectDate;
    private String topic;
    private String subject;
    private String question;
    private String status;
    private String answer;
}