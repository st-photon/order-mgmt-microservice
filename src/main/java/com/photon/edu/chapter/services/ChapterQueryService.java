package com.photon.edu.chapter.services;

import com.photon.edu.chapter.data.ChapterData;
import com.photon.edu.chapter.entity.Chapter;

import java.util.List;
import java.util.UUID;

public interface ChapterQueryService {

    List<ChapterData> fetchAll();

    ChapterData fetchById(UUID chapterId);
}
