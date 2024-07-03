package com.photon.edu.chapter.services;

import com.photon.edu.chapter.data.ChapterData;
import com.photon.edu.chapter.entity.Chapter;
import com.photon.edu.chapter.helpers.ChapterMapperHelper;
import com.photon.edu.chapter.repository.ChapterRepository;
import com.photon.edu.chapter.repository.ChapterRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChapterQueryServiceImpl implements ChapterQueryService {

    private final ChapterRepository chapterRepository;

    private final ChapterRepositoryWrapper chapterRepositoryWrapper;

    private final ChapterMapperHelper chapterMapperHelper;

    @Override
    public ChapterData fetchById(UUID chapterId) {
        final Chapter chapter = chapterRepositoryWrapper.findById(chapterId);
        return chapterMapperHelper.to(chapter);
    }

    @Override
    public List<ChapterData> fetchAll() {
        return chapterRepository.findAll().stream().map(chapterMapperHelper::to).toList();
    }
}
