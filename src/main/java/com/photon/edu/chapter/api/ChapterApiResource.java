package com.photon.edu.chapter.api;

import com.photon.core.Response;
import com.photon.edu.chapter.data.ChapterData;
import com.photon.edu.chapter.request.CreateChapterRequest;
import com.photon.edu.chapter.request.UpdateChapterRequest;
import com.photon.edu.chapter.services.ChapterCommandService;
import com.photon.edu.chapter.services.ChapterQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/chapters")
@Tag(name = "ChapterApiResource")
public class ChapterApiResource {

    private final ChapterCommandService chapterCommandService;

    private final ChapterQueryService chapterQueryService;

    @GetMapping
    public List<ChapterData> fetchAll() {
        return chapterQueryService.fetchAll();
    }

    @GetMapping("/{id}")
    public ChapterData fetchById(@PathVariable UUID id) {
        return this.chapterQueryService.fetchById(id);
    }

    @PostMapping
    public Response save(@RequestBody CreateChapterRequest createChapterRequest) {
        return this.chapterCommandService.save(createChapterRequest);
    }

    @PutMapping("/{id}")
    public Response update(@PathVariable UUID id, @RequestBody UpdateChapterRequest updateChapterRequest) {
        return this.chapterCommandService.update(id, updateChapterRequest);
    }
}
