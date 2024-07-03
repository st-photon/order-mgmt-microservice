package com.photon.edu.chapter.helpers;

import com.photon.edu.chapter.data.ChapterData;
import com.photon.edu.chapter.entity.Chapter;
import com.photon.edu.chapter.request.CreateChapterRequest;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class ChapterMapperHelper {

    public Chapter to(CreateChapterRequest createChapterRequest) {
        final Chapter chapter = new Chapter();
        chapter.setChapterNo(createChapterRequest.getChapterNo());
        chapter.setTopic(createChapterRequest.getTopic());
        chapter.setShortDescription(createChapterRequest.getShortDescription());
        return chapter;
    }

    public ChapterData to(final Chapter chapter) {
        final ChapterData chapterData = new ChapterData();
        chapterData.setChapterNo(chapter.getChapterNo());
        chapterData.setTopic(chapter.getTopic());
        chapterData.setShortDescription(chapter.getShortDescription());
        chapterData.setId(chapter.getId());
        return chapterData;
    }
}
