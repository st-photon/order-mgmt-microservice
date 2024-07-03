package com.photon.edu.question.request;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreateQuestionRequest {

    private String topic;

    private UUID chapterId;

    private String questionType;

    private Float questionNo;

    private String shortDescription;
}
