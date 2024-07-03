package com.photon.edu.chapter.services;

import com.photon.core.Response;
import com.photon.edu.chapter.request.CreateChapterRequest;
import com.photon.edu.chapter.request.UpdateChapterRequest;

import java.util.UUID;

public interface ChapterCommandService {

    Response save(CreateChapterRequest createChapterRequest);

    Response update(UUID id, UpdateChapterRequest updateChapterRequest);
}
