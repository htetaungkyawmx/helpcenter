package com.hak.helpcenter.controller;

import com.hak.helpcenter.dto.helpcenter.FrequentQuestionsDto;
import com.hak.helpcenter.dto.helpcenter.UserQuestionsDto;
import com.hak.helpcenter.service.IFrequentQuestionsService;
import com.hak.helpcenter.service.IUserQuestionsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "APIs for Help Center",
        description = "REST APIs for managing Help Center content including FAQs and user questions"
)
@RestController
@RequiredArgsConstructor
@RequestMapping("/aioceaneye/helpcenter")
//@CrossOrigin("*")
public class HelpCenterController {

    private final IFrequentQuestionsService frequentQuestionsService;
    private final IUserQuestionsService userQuestionsService;

    // Frequent Questions Endpoints
    @PostMapping("/frequent-questions")
    public ResponseEntity<String> createFrequentQuestion(@RequestBody FrequentQuestionsDto frequentQuestionsDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(frequentQuestionsService.createFrequentQuestion(frequentQuestionsDto));
    }

    @GetMapping("/frequent-questions/{questionId}")
    public ResponseEntity<FrequentQuestionsDto> getFrequentQuestionById(@PathVariable int questionId) {
        return ResponseEntity.ok(frequentQuestionsService.getFrequentQuestionById(questionId));
    }

    @PutMapping("/frequent-questions/{questionId}")
    public ResponseEntity<String> updateFrequentQuestion(
            @PathVariable int questionId,
            @RequestBody FrequentQuestionsDto frequentQuestionsDto) {
        return ResponseEntity.ok(frequentQuestionsService.updateFrequentQuestions(questionId, frequentQuestionsDto));
    }

    @DeleteMapping("/frequent-questions/{questionId}")
    public ResponseEntity<String> deleteFrequentQuestion(@PathVariable int questionId) {
        return ResponseEntity.ok(frequentQuestionsService.deleteFrequentQuestion(questionId));
    }

    // User Questions Endpoints
    @PostMapping("/user-questions")
    public ResponseEntity<String> createUserQuestion(@RequestBody UserQuestionsDto userQuestionsDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userQuestionsService.createUserQuestion(userQuestionsDto));
    }

    @GetMapping("/user-questions/{questionId}")
    public ResponseEntity<UserQuestionsDto> getUserQuestionById(@PathVariable int questionId) {
        return ResponseEntity.ok(userQuestionsService.fetchUserQuestionsDetailsById(questionId));
    }

    @PutMapping("/user-questions/{questionId}")
    public ResponseEntity<String> updateUserQuestion(
            @PathVariable int questionId,
            @RequestBody UserQuestionsDto userQuestionsDto) {
        return ResponseEntity.ok(userQuestionsService.updateUserQuestions(questionId, userQuestionsDto));
    }

    @DeleteMapping("/user-questions/{questionId}")
    public ResponseEntity<String> deleteUserQuestion(@PathVariable int questionId) {
        return ResponseEntity.ok(userQuestionsService.deleteUserQuestions(questionId));
    }
}