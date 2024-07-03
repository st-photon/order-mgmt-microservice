package com.photon.edu.question.request;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UpdateQuestionRequest {

    private String topic;

    private String shortDescription;

    private Float questionNo;

    private UUID chapterId;

    private String questionType;
}
