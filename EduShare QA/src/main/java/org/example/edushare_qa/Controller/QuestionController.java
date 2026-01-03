package org.example.edushare_qa.Controller;

import lombok.extern.slf4j.Slf4j;
import org.example.edushare_qa.Pojo.Question;
import org.example.edushare_qa.Pojo.Result;
import org.example.edushare_qa.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/question")
@Slf4j
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    /**
     * 添加问题
     */
     @PostMapping("/add")
     public Result add(@RequestBody Question question){
        log.info("添加问题,参数:{}",question);
        questionService.add(question);
        return Result.success();
    }
     /**
     * 查询所有问题
     */
     @GetMapping("/findall")
      public Result findAll(){
        log.info("查询所有问题");
        List<Question> list = questionService.findAll();
        return Result.success(list);
    }
    /**
     * 查询当前用户上传问题数
     */
    @GetMapping("/findUploadCount/{authorId}")
    public Result findUploadCount(@PathVariable String authorId){
        log.info("查询当前用户上传问题数");
        int count = questionService.findUploadCount(authorId);
        return Result.success(count);
    }
    /**
     * 分类查询问题
     */
    @PostMapping("/findByItem")
    public Result findByItem(@RequestBody Question question) {
        log.info("分类查询问题");
        List<Question> list = questionService.findByItem(question);
        return Result.success(list);
    }
    /**
     * 查询回显
     */
    @GetMapping("{id}")
    public Result getInfo(@PathVariable Integer id) {
        log.info("查询回显,参数:{}", id);
         Question questionParam = questionService.getInfo(id);
        return Result.success(questionParam);
    }

    /**
     * 修改问题
     * @param question
     * @return
     */
    @PutMapping
    public Result update(@RequestBody Question question) {
        log.info("修改问题,参数:{}", question);
        questionService.update(question);
        return Result.success();
    }
    /**删除问题
     * @param id
     * @return
     */
     @DeleteMapping("/{id}")
     public Result delete(@PathVariable Long id) {
        log.info("删除问题,参数:{}", id);
        questionService.delete(id);
        return Result.success();
    }
    /**
     * 复合查询当前教师所负责的课程发布的问题
     */
     @GetMapping("/findQuestionByTeacherName/{teacherName}")
     public Result findQuestionByTeacherName(@PathVariable String teacherName){
        log.info("复合查询当前教师所负责的课程发布的问题,参数:{}",teacherName);
        List<Question> list = questionService.findQuestionByTeacherName(teacherName);
        return Result.success(list);
     }
}
