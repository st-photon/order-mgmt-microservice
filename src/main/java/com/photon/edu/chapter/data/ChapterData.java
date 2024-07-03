package com.photon.edu.chapter.data;

import lombok.Data;

import java.util.UUID;

@Data
public class ChapterData {

    private UUID id;

    private String topic;

    private String shortDescription;

    private Float chapterNo;
}
