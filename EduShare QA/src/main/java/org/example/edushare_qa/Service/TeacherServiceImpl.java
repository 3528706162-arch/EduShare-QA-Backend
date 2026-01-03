package org.example.edushare_qa.Service;

import lombok.extern.slf4j.Slf4j;
import org.example.edushare_qa.Mapper.TeacherMapper;
import org.example.edushare_qa.Pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class TeacherServiceImpl implements TeacherService{
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public void add(Teacher teacher) {
        teacher.setCreatedAt(LocalDateTime.now());
        teacherMapper.Register(teacher);
        teacherMapper.add(teacher);
    }

    @Override
    public List<Teacher> findAll() {
        List<Teacher> teachers = teacherMapper.findAll();
        return teachers;
    }

    @Override
    public void delete(List<Integer> ids) {
        teacherMapper.delete(ids);
    }

    @Override
    public Teacher getInfo(Integer id) {
        Teacher teacher = teacherMapper.getInfo(id);
        return teacher;
    }

    @Override
    public void update(Teacher teacher) {
        teacherMapper.update(teacher);
    }

    @Override
    public Teacher getInfoByUsername(String username) {
        Teacher teacher = teacherMapper.getInfoByUsername(username);
        return teacher;
    }
}
