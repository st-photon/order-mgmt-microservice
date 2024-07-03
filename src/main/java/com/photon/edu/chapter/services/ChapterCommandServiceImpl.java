package com.photon.edu.chapter.services;

import com.photon.core.Response;
import com.photon.edu.chapter.entity.Chapter;
import com.photon.edu.chapter.helpers.ChapterMapperHelper;
import com.photon.edu.chapter.repository.ChapterRepository;
import com.photon.edu.chapter.repository.ChapterRepositoryWrapper;
import com.photon.edu.chapter.request.CreateChapterRequest;
import com.photon.edu.chapter.request.UpdateChapterRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChapterCommandServiceImpl implements ChapterCommandService {

    private final ChapterRepository chapterRepository;

    private final ChapterRepositoryWrapper chapterRepositoryWrapper;

    private final ChapterMapperHelper chapterMapperHelper;

    @Override
    public Response save(CreateChapterRequest createChapterRequest) {
        try {
            Chapter chapter = chapterMapperHelper.to(createChapterRequest);
            chapter = this.chapterRepository.saveAndFlush(chapter);
            return Response.of(chapter.getId());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Response update(UUID id, UpdateChapterRequest updateChapterRequest) {
        try {
            Chapter chapter = chapterRepositoryWrapper.findById(id);
            chapter.setChapterNo(updateChapterRequest.getChapterNo());
            chapter.setTopic(updateChapterRequest.getTopic());
            chapter.setShortDescription(updateChapterRequest.getShortDescription());
            chapter = this.chapterRepository.saveAndFlush(chapter);
            return Response.of(chapter.getId());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
