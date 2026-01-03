package org.example.edushare_qa.Service;

import lombok.extern.slf4j.Slf4j;
import org.example.edushare_qa.Mapper.QuestionMapper;
import org.example.edushare_qa.Pojo.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public void add(Question question) {
        question.setIsSolved("0");
        question.setCreatedAt(LocalDateTime.now());
        questionMapper.add(question);
        log.info("添加问题,参数:{}",question);
    }

    @Override
    public List<Question> findAll() {
        List<Question> questions = questionMapper.findAll();
        return questions;
    }

    @Override
    public int findUploadCount(String authorId) {
        return questionMapper.findUploadCount(authorId);
    }

    @Override
    public List<Question> findByItem(Question question) {
        List<Question> questions = questionMapper.findByItem(question);
        return questions;
    }

    @Override
    public void update(Question question) {
        questionMapper.update(question);
    }

    @Override
    public void delete(Long id) {
        questionMapper.delete(id);
    }

    @Override
    public Question getInfo(Integer id) {
        Question question = questionMapper.getInfo(id);
        return question;
    }

    @Override
    public List<Question> findQuestionByTeacherName(String teacherName) {
        List<Question> list = questionMapper.findQuestionByTeacherName(teacherName);
        return list;
    }
}
