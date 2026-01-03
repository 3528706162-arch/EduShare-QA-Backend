package org.example.edushare_qa.Service;

import org.example.edushare_qa.Pojo.Question;

import java.util.List;

public interface QuestionService {
    void add(Question question);

    List<Question> findAll();

    int findUploadCount(String authorId);

    List<Question> findByItem(Question question);

    void update(Question question);

    void delete(Long id);

    Question getInfo(Integer id);

    List<Question> findQuestionByTeacherName(String teacherName);
}
