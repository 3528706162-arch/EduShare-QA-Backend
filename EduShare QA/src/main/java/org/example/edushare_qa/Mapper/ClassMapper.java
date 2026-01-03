package org.example.edushare_qa.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.edushare_qa.Pojo.Classes;

import java.util.List;

@Mapper
public interface ClassMapper {
    @Insert("insert into classes(title,class_type,description,institute,teacher_name,created_at,updated_at) values(#{title},#{classType},#{description},#{institute},#{teacherName},#{createdAt},#{updatedAt})")
    void add(Classes clazz);

    @Select("select * from classes")
    List<Classes> findAll();

    void delete(List<Integer> ids);

    @Select("select * from classes where id=#{id}")
    Classes getInfo(Integer id);


    void update(Classes clazz);

    @Select("select * from classes where teacher_name=#{teacherName}")
    List<Classes> findByTeacherName(String teacherName);
}
