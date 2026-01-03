package org.example.edushare_qa.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.edushare_qa.Pojo.Teacher;

import java.util.List;

@Mapper
public interface TeacherMapper {

    //添加老师，同时注册用户
    @Insert("insert into teachers(name,username,email,password,phonenumber,classes_name,introduction,title,created_at) values(#{name},#{username},#{email},#{password},#{phonenumber},#{classesName},#{introduction},#{title},#{createdAt})")
    void add(Teacher teacher);

    @Insert("insert into users(username,email,password,role,phonenumber,created_at) values(#{username},#{email},#{password},'teacher',#{phonenumber},#{createdAt})")
    void Register(Teacher teacher);

    @Select("select * from teachers")
    List<Teacher> findAll();

    void delete(List<Integer> ids);

    @Select("select * from teachers where id=#{id}")
    Teacher getInfo(Integer id);

    void update(Teacher teacher);

    @Select("select * from teachers where username= #{username}")
    Teacher getInfoByUsername(String username);
}
