package com.photon.edu.chapter.repository;

import com.photon.edu.chapter.entity.Chapter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChapterRepositoryWrapper {

    private final ChapterRepository chapterRepository;

    public Chapter findById(UUID chapterId) {
        return chapterRepository.findById(chapterId).orElseThrow(() -> new RuntimeException("chapter not found"));
    }
}
