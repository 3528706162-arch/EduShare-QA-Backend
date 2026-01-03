package org.example.edushare_qa.Mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.edushare_qa.Pojo.Question;

import java.util.List;

@Mapper
public interface QuestionMapper {
    @Insert("insert into questions(title,content,author_id,question_type,class_belong,file_url,tags,created_at,is_solved) values(#{title},#{content},#{authorId},#{questionType},#{classBelong},#{fileUrl},#{tags},#{createdAt},#{isSolved})")
    void add(Question question);

    @Select("select * from questions")
    List<Question> findAll();

    @Select("select count(*) from questions where author_id = #{authorId}")
    int findUploadCount(String authorId);

    List<Question> findByItem(Question question);

    void update(Question question);

    @Delete("delete from questions where id = #{id}")
    void delete(Long id);

    @Select("select * from questions where id = #{id}")
    Question getInfo(Integer id);

    @Select("select * from questions where class_belong in (select classes.title from classes where teacher_name = #{teacherName}) and is_solved = 0;")
    List<Question> findQuestionByTeacherName(String teacherName);
}
