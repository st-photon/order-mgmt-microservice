package com.photon.edu.question.data;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class QuestionData {

    private UUID id;

    private String topic;

    private String shortDescription;

    private Float questionNo;
}
