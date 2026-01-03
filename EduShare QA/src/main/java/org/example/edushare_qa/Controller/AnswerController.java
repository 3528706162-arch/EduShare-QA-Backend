package org.example.edushare_qa.Controller;

import lombok.extern.slf4j.Slf4j;
import org.example.edushare_qa.Pojo.Answer;
import org.example.edushare_qa.Pojo.Result;
import org.example.edushare_qa.Service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/answer")
@Slf4j
public class AnswerController {
    @Autowired
    private AnswerService answerService;
    /**
     * 新增回答同时设置问题状态为已解决
     */
    @PostMapping
    public Result add(@RequestBody Answer answer){
        answerService.add(answer);
        return Result.success();
    }
    /**
     * 查看当前用户回答问题数
     */
    @GetMapping("/findAnswerCount/{authorId}")
    public Result findAnswerCount(@PathVariable String authorId){
        int count = answerService.findUploadCount(authorId);
        return Result.success(count);
    }
    /**
     * 查看当前用户回答问题
     */
    @GetMapping("/findAnswers/{authorId}")
    public Result findAnswers(@PathVariable String authorId){
        List<Answer> list = answerService.findAnswers(authorId);
        return Result.success(list);
    }
    /**
     * 学生端依据问题id查询回答
     */
    @GetMapping("/findAnswersByQuestionId/{questionId}")
    public Result findAnswersByQuestionId(@PathVariable Integer questionId){
        Answer answer = answerService.findAnswersByQuestionId(questionId);
        return Result.success(answer);
    }
    /**
     * 查询回显
     */
    @GetMapping("{id}")
    public Result getInfo(@PathVariable Integer id) {
        log.info("查询回显,参数:{}", id);
        Answer answer = answerService.getInfo(id);
        return Result.success(answer);
    }
    /**
     * 修改回答
     */
    @PutMapping
    public Result update(@RequestBody Answer answer){
        answerService.update(answer);
        return Result.success();
    }
    /**
     * 删除回答
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        answerService.delete(id);
        return Result.success();
    }
    }
