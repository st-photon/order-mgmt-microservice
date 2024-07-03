package com.photon.edu.chapter.request;

import lombok.Data;

import java.util.UUID;

@Data
public class UpdateChapterRequest {

    private String topic;

    private String shortDescription;

    private UUID standardId;

    private UUID languageId;

    private UUID boardId;

    private UUID subjectId;

    private Float chapterNo;
}
