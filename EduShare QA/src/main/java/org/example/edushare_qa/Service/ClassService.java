package org.example.edushare_qa.Service;
import org.example.edushare_qa.Pojo.Classes;

import java.util.List;

public interface ClassService {
    void add(Classes clazz);

    List<Classes> findAll();

    void delete(List<Integer> ids);

    Classes getInfo(Integer id);

    void update(Classes clazz);

    List<Classes> findByTeacherName(String teacherName);
}
