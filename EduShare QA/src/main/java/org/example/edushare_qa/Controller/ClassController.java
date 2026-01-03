package org.example.edushare_qa.Controller;

import lombok.extern.slf4j.Slf4j;
import org.example.edushare_qa.Pojo.Result;
import org.example.edushare_qa.Pojo.Classes;
import org.example.edushare_qa.Service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/api/v1/class")
public class ClassController {
    @Autowired
    private ClassService classService;

    /**
     * 添加课程
     * @param clazz
     * @return
     */
    @PostMapping("/add")
    public Result Classadd(@RequestBody Classes clazz){
        log.info("添加课程,参数:{}",clazz);
        classService.add(clazz);
        return Result.success();
    }
    /**
     * 查询所有课程
     */
    @GetMapping("/findall")
    public Result findAll(){
        log.info("查询所有课程");
        List<Classes> list = classService.findAll();
        return Result.success(list);
    }
    /**
     * 批量删除课程
     */
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids){
        log.info("删除设备,参数:{}",ids);
        classService.delete(ids);
        return Result.success();
    }
    /**
     * 查询回显
     */
    @GetMapping("{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("查询回显,参数:{}",id);
        Classes clazz = classService.getInfo(id);
        return Result.success(clazz);
    }
    /**
     * 修改课程
     */
    @PutMapping
    public Result update(@RequestBody Classes clazz){
        log.info("修改课程,参数:{}",clazz);
        classService.update(clazz);
        return Result.success();
    }
    /**
     * 查询当前老师所负责的课程
     */
    @GetMapping("/findByTeacherName/{teacherName}")
    public Result findByTeacherName(@PathVariable String teacherName){
        log.info("查询当前老师所负责的课程,参数:{}",teacherName);
        List<Classes> list = classService.findByTeacherName(teacherName);
        return Result.success(list);
    }
}
