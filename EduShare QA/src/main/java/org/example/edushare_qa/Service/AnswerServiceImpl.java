package org.example.edushare_qa.Service;

import org.example.edushare_qa.Mapper.AnswerMapper;
import org.example.edushare_qa.Pojo.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService{
    @Autowired
    private AnswerMapper answerMapper;

    @Override
    public void add(Answer answer) {
        answer.setCreatedAt(LocalDateTime.now());
        answerMapper.add(answer);
        answerMapper.changeQuestionIsSolved(answer.getQuestionId());
    }

    @Override
    public int findUploadCount(String authorId) {
        return answerMapper.findUploadCount(authorId);
    }

    @Override
    public List<Answer> findAnswers(String authorId) {
        return answerMapper.findAnswers(authorId);
    }

    @Override
    public Answer getInfo(Integer id) {
        return answerMapper.selectById(id);
    }

    @Override
    public void update(Answer answer) {
        answerMapper.update(answer);
    }

    @Override
    public void delete(Integer id) {
        answerMapper.delete(id);
    }

    @Override
    public Answer findAnswersByQuestionId(Integer questionId) {
        return answerMapper.findAnswersByQuestionId(questionId);
    }
}
