package org.example.edushare_qa.Controller;

import lombok.extern.slf4j.Slf4j;
import org.example.edushare_qa.Pojo.Result;
import org.example.edushare_qa.Pojo.Teacher;
import org.example.edushare_qa.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/v1/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    /**新增老师
     *
     * @param teacher
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody Teacher teacher){
        teacherService.add(teacher);
        return Result.success();
    }
    /**
     * 查询所有老师
     */
    @GetMapping("/findall")
    public Result findAll(){
        List<Teacher> list = teacherService.findAll();
        return Result.success(list);
    }
    /**
     * 批量删除老师
     */
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids){
        log.info("删除设备,参数:{}",ids);
        teacherService.delete(ids);
        return Result.success();
    }
    /**
     * 查询回显
     */
    @GetMapping("{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("查询回显,参数:{}",id);
        Teacher teacher = teacherService.getInfo(id);
        return Result.success(teacher);
    }
    /**
     * 修改老师
     */
    @PutMapping
    public Result update(@RequestBody Teacher teacher){
        log.info("修改老师,参数:{}",teacher);
        teacherService.update(teacher);
        return Result.success();
    }
    /**
     * 获取教师信息
     */
    @GetMapping("/getInfoByUsername/{username}")
    public Result getInfoByUsername(@PathVariable String username){
        log.info("获取教师信息,参数:{}",username);
        Teacher teacher = teacherService.getInfoByUsername(username);
        return Result.success(teacher);
    }
}
