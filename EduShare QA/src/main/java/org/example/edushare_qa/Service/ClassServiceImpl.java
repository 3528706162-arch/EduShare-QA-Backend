package org.example.edushare_qa.Service;

import lombok.extern.slf4j.Slf4j;
import org.example.edushare_qa.Mapper.ClassMapper;
import org.example.edushare_qa.Pojo.Classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class ClassServiceImpl implements ClassService{
    @Autowired
    private ClassMapper classMapper;
    @Override
    public void add(Classes clazz) {
        clazz.setCreatedAt(LocalDateTime.now());
        clazz.setUpdatedAt(LocalDateTime.now());
        classMapper.add(clazz);
    }

    @Override
    public List<Classes> findAll() {
        List<Classes> classes = classMapper.findAll();
        return classes;
    }

    @Override
    public void delete(List<Integer> ids) {
        classMapper.delete(ids);
    }

    @Override
    public Classes getInfo(Integer id) {
        Classes clazz = classMapper.getInfo(id);
        return clazz;
    }

    @Override
    public void update(Classes clazz) {
        clazz.setUpdatedAt(LocalDateTime.now());
        classMapper.update(clazz);
    }

    @Override
    public List<Classes> findByTeacherName(String teacherName) {
        List<Classes> list = classMapper.findByTeacherName(teacherName);
        return list;
    }
}
