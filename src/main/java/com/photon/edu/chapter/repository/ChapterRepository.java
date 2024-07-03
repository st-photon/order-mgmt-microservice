package com.photon.edu.chapter.repository;

import com.photon.edu.chapter.entity.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChapterRepository extends JpaRepository<Chapter, UUID> {
}
