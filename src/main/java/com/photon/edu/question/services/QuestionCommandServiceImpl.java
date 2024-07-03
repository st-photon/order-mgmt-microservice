package com.photon.edu.question.services;

import com.photon.core.Response;
import com.photon.edu.question.entity.Question;
import com.photon.edu.question.enums.QuestionType;
import com.photon.edu.question.helpers.QuestionMapperHelper;
import com.photon.edu.question.repository.QuestionRepository;
import com.photon.edu.question.repository.QuestionRepositoryWrapper;
import com.photon.edu.question.request.CreateQuestionRequest;
import com.photon.edu.question.request.UpdateQuestionRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class QuestionCommandServiceImpl implements QuestionCommandService {

    private final QuestionRepository questionRepository;

    private final QuestionRepositoryWrapper questionRepositoryWrapper;

    private final QuestionMapperHelper questionMapperHelper;

    @Override
    public Response save(CreateQuestionRequest request) {
        try {
            Question question = questionMapperHelper.to(request);
            question = this.questionRepository.saveAndFlush(question);
            return Response.of(question.getId());
        } catch(Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Response update(UUID id, UpdateQuestionRequest request) {
        try {
            Question question = this.questionRepositoryWrapper.findById(id);
            question.setQstType(QuestionType.getEnumByString(request.getQuestionType()));
            question.setTopic(request.getTopic());
            question.setQstNo(request.getQuestionNo());
            question = this.questionRepository.saveAndFlush(question);
            return Response.of(question.getId());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
