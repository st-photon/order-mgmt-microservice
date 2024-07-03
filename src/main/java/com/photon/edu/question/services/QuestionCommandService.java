package com.photon.edu.question.services;

import com.photon.core.Response;
import com.photon.edu.question.request.CreateQuestionRequest;
import com.photon.edu.question.request.UpdateQuestionRequest;

import java.util.UUID;

public interface QuestionCommandService {
    Response save(CreateQuestionRequest request);

    Response update(UUID id, UpdateQuestionRequest request);
}
