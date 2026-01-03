package org.example.edushare_qa.Service;

import org.example.edushare_qa.Pojo.Answer;

import java.util.List;

public interface AnswerService {
    void add(Answer answer);

    int findUploadCount(String authorId);

    List<Answer> findAnswers(String authorId);

    Answer getInfo(Integer id);

    void update(Answer answer);

    void delete(Integer id);

    Answer findAnswersByQuestionId(Integer questionId);
}
