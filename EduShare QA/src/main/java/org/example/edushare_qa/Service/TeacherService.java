package org.example.edushare_qa.Service;

import org.example.edushare_qa.Pojo.Teacher;

import java.util.List;

public interface TeacherService {
    void add(Teacher teacher);

    List<Teacher> findAll();

    void delete(List<Integer> ids);

    Teacher getInfo(Integer id);

    void update(Teacher teacher);

    Teacher getInfoByUsername(String username);
}
