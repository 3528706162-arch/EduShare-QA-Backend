package org.example.edushare_qa.Mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.edushare_qa.Pojo.Answer;

import java.util.List;

@Mapper
public interface AnswerMapper {
    @Select("insert into answers(question_id,content,author_id,file_url,created_at) values(#{questionId},#{content},#{authorId},#{fileUrl},#{createdAt})")
    void add(Answer answer);

    @Update("update questions set is_solved = 1 where id = #{questionId}")
    void changeQuestionIsSolved(String questionId);

    @Select("select count(*) from answers where author_id = #{authorId}")
    int findUploadCount(String authorId);

    @Select("select * from answers where author_id = #{authorId}")
    List<Answer> findAnswers(String authorId);

    @Select("select * from answers where id = #{id}")
    Answer selectById(Integer id);

    void update(Answer answer);

    @Delete("delete from answers where id = #{id}")
    void delete(Integer id);

    @Select("select * from answers where question_id = #{questionId}")
    Answer findAnswersByQuestionId(Integer questionId);
}
