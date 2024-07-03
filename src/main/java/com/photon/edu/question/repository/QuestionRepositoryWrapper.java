package com.photon.edu.question.repository;

import com.photon.edu.question.entity.Question;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
public class QuestionRepositoryWrapper {

    private final QuestionRepository questionRepository;

    public Question findById(UUID id) {
        return this.questionRepository.findById(id).orElseThrow(() -> new RuntimeException("Question not found"));
    }
}
