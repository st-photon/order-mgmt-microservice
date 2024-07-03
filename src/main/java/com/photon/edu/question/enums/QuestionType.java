package com.photon.edu.question.enums;

import java.util.Arrays;
import java.util.Optional;

public enum QuestionType {

    MULTI_OPTION("multi option"), NO_OPTION("no option");

    private final String questionType;

    QuestionType(String questionType) {
        this.questionType = questionType;
    }

    public static QuestionType getEnumByString(String questionTypeStr) {
        QuestionType[] types = QuestionType.values();
        Optional<QuestionType> questionTypeOptional = Arrays.stream(types).filter(t -> t.name().equals(questionTypeStr)).findFirst();
        if(questionTypeOptional.isEmpty()) {
            throw new RuntimeException(String.format("Question type not matched %s", questionTypeStr));
        }
        return questionTypeOptional.get();
    }
}
