package org.example.edushare_qa.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.edushare_qa.Pojo.LoginParam;
import org.example.edushare_qa.Pojo.User;

@Mapper
public interface UserMapper {
    @Insert("insert into users(username,password,email,role,phonenumber,created_at) values(#{username},#{password},#{email},#{role},#{phonenumber},#{createdAt})")
    void Register(User user);

    @Select("select * from users where username=#{username} and password=#{password}")
    User login(LoginParam loginParam);

    @Select("select username from users where id=#{id}")
    Object getUsername(Long id);

    @Select("select * from users where id= #{id}")
    User findInfo(Long id);

    void update(User user);
}
