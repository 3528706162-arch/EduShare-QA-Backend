package org.example.edushare_qa.Controller;

import org.example.edushare_qa.Pojo.Result;
import org.example.edushare_qa.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/report")
public class ReportController {
    @Autowired
    private ReportService reportService;
    /**
     * 统计用户数量
     */
    @GetMapping("/userCount")
    public Result userCount(){
        int count = reportService.userCount();
        return Result.success(count);
    }
    /**
     * 统计资源数量
     */
    @GetMapping("/resourceCount")
    public Result resourceCount(){
        int count = reportService.resourceCount();
        return Result.success(count);
    }
    /**
     * 统计问题数量
     */
    @GetMapping("/questionCount")
    public Result questionCount(){
        int count = reportService.questionCount();
        return Result.success(count);
    }
    /**
     * 统计回答数量
     */
    @GetMapping("/answerCount")
    public Result answerCount(){
        int count = reportService.answerCount();
        return Result.success(count);
    }
    /**
     * 统计三种身份的用户数量
     */
    @GetMapping("/identityCount")
    public Result identityCount(){
        List<Map<String,Integer>> count = reportService.identityCount();
        return Result.success(count);
    }
    /**
     * 统计随时间变化的用户注册数量
     */
    @GetMapping("/userCountByTime")
    public Result userCountByTime(){
        List<Map<String,Integer>> count = reportService.userCountByTime();
        return Result.success(count);
    }
}
