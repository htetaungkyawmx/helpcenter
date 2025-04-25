package com.hak.helpcenter.dto.helpcenter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class FrequentQuestionsDto {

    private Integer questionId;
    private Integer questionCode;
    private String question;
    private String answer;

}
