package org.example.edushare_qa.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReportMapper {
    @Select("select count(*) from users")
    int userCount();

    @Select("select count(*) from resources")
    int resourceCount();

    @Select("select count(*) from questions")
    int questionCount();

    @Select("select count(*) from answers")
    int answerCount();

    @Select("select role,count(*) as count from users group by role;")
    List<Map<String, Integer>> identityCount();

    @Select("select date(created_at) as date,count(*) as count from users group by date;")
    List<Map<String, Integer>> userCountByTime();
}
