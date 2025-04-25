package com.hak.helpcenter.service.impl;

import com.hak.helpcenter.dto.helpcenter.FrequentQuestionsDto;
import com.hak.helpcenter.mapper.FrequentQuestionsMapper;
import com.hak.helpcenter.model.FrequentQuestions;
import com.hak.helpcenter.repository.FrequentQuestionsRepository;
import com.hak.helpcenter.service.IFrequentQuestionsService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class FrequentQuestionsServiceImpl implements IFrequentQuestionsService {

    private final FrequentQuestionsRepository frequentQuestionsRepository;
    private final FrequentQuestionsMapper frequentQuestionsMapper;

    @Override
    public String createFrequentQuestion(FrequentQuestionsDto form) {
        FrequentQuestions entity = frequentQuestionsMapper.toEntity(form);
        FrequentQuestions savedEntity = frequentQuestionsRepository.save(entity);
        return "Frequent question: " + savedEntity.getQuestion() + " saved successfully.";
    }

    @Override
    public String updateFrequentQuestions(int questionId, FrequentQuestionsDto form) {
        FrequentQuestions existingEntity = frequentQuestionsRepository.findById(questionId)
                .orElseThrow(() -> new EntityNotFoundException("Frequent question not found with id: " + questionId));

        frequentQuestionsMapper.updateEntity(existingEntity, form);
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
}