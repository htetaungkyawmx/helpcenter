package com.hak.helpcenter.service.impl;

import com.hak.helpcenter.dto.helpcenter.FrequentQuestionsDto;
import com.hak.helpcenter.mapper.FrequentQuestionsMapper;
import com.hak.helpcenter.model.FrequentQuestions;
import com.hak.helpcenter.repository.FrequentQuestionsRepository;
import com.hak.helpcenter.service.IFrequentQuestionsService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class FrequentQuestionsServiceImpl implements IFrequentQuestionsService {

    private final FrequentQuestionsRepository frequentQuestionsRepository;
    private final FrequentQuestionsMapper frequentQuestionsMapper;

    @Override
    public String createFrequentQuestion(FrequentQuestionsDto form) {
        // Ensure the questionId is null to force a new entity creation
        form.setQuestionId(null); // Reset the ID to ensure a new entity is created
        FrequentQuestions entity = frequentQuestionsMapper.toEntity(form);

        // Retry mechanism for optimistic locking
        int maxRetries = 3;
        int attempt = 0;
        while (attempt < maxRetries) {
            try {
                FrequentQuestions savedEntity = frequentQuestionsRepository.save(entity);
                return "Frequent question: " + savedEntity.getQuestion() + " saved successfully.";
            } catch (ObjectOptimisticLockingFailureException e) {
                attempt++;
                if (attempt == maxRetries) {
                    throw new RuntimeException("Failed to save frequent question after " + maxRetries + " attempts due to concurrent modifications", e);
                }
                // Optional: Add a small delay before retrying
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Retry interrupted", ie);
                }
            }
        }
        throw new RuntimeException("Unexpected error while saving frequent question");
    }

    @Override
    public String updateFrequentQuestions(int questionId, FrequentQuestionsDto form) {
        FrequentQuestions existingEntity = frequentQuestionsRepository.findById(questionId)
                .orElseThrow(() -> new EntityNotFoundException("Frequent question not found with id: " + questionId));

        frequentQuestionsMapper.updateEntity(existingEntity, form);
        frequentQuestionsRepository.save(existingEntity); // Ensure the update is saved
        return "Frequent question: " + existingEntity.getQuestion() + " updated successfully.";
    }

    @Override
    @Transactional(readOnly = true)
    public FrequentQuestionsDto getFrequentQuestionById(int questionId) {
        FrequentQuestions entity = frequentQuestionsRepository.findById(questionId)
                .orElseThrow(() -> new EntityNotFoundException("Frequent question not found with id: " + questionId));
        return frequentQuestionsMapper.toDto(entity);
    }

    @Override
    public String deleteFrequentQuestion(int questionId) {
        if (!frequentQuestionsRepository.existsById(questionId)) {
            throw new EntityNotFoundException("Frequent question not found with id: " + questionId);
        }
        frequentQuestionsRepository.deleteById(questionId);
        return "Frequent question with ID: " + questionId + " deleted successfully.";
    }

    @Override
    @Transactional(readOnly = true)
    public List<FrequentQuestionsDto> getAllFrequentQuestions() {
        List<FrequentQuestions> questions = frequentQuestionsRepository.findAll();
        return questions.stream()
                .map(frequentQuestionsMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<FrequentQuestionsDto> getFeaturedFrequentQuestions() {
        List<FrequentQuestions> questions = frequentQuestionsRepository.findByIsFeaturedTrue();
        return questions.stream()
                .map(frequentQuestionsMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<FrequentQuestionsDto> getFrequentQuestionsByCategory(String category) {
        List<FrequentQuestions> questions = frequentQuestionsRepository.findByCategory(category);
        return questions.stream()
                .map(frequentQuestionsMapper::toDto)
                .collect(Collectors.toList());
    }
}
