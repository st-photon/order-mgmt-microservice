package com.photon.edu.question.helpers;

import com.photon.edu.chapter.entity.Chapter;
import com.photon.edu.chapter.repository.ChapterRepositoryWrapper;
import com.photon.edu.question.data.QuestionData;
import com.photon.edu.question.entity.Question;
import com.photon.edu.question.enums.QuestionType;
import com.photon.edu.question.request.CreateQuestionRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class QuestionMapperHelper {

    private final ChapterRepositoryWrapper chapterRepositoryWrapper;

    public Question to(CreateQuestionRequest request) {
        final Chapter chapter = chapterRepositoryWrapper.findById(request.getChapterId());
        final Question question = new Question();
        question.setTopic(request.getTopic());
        question.setChapter(chapter);
        question.setQstNo(request.getQuestionNo());
        question.setQstType(QuestionType.getEnumByString(request.getQuestionType()));
        return question;
    }

    public QuestionData to(final Question question) {
        final QuestionData questionData = new QuestionData();
        questionData.setId(question.getId());
        questionData.setQuestionNo(questionData.getQuestionNo());
        questionData.setTopic(question.getTopic());
        questionData.setShortDescription(questionData.getShortDescription());
        return questionData;
    }
}
