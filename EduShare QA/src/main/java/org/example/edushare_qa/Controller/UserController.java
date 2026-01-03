package org.example.edushare_qa.Controller;

import lombok.extern.slf4j.Slf4j;
import org.example.edushare_qa.Pojo.LoginParam;
import org.example.edushare_qa.Pojo.Result;
import org.example.edushare_qa.Pojo.Teacher;
import org.example.edushare_qa.Pojo.User;
import org.example.edushare_qa.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户注册
     * @param user
     * @return
     */
    @PostMapping("/Register")
    public Result UserRegister(@RequestBody User user){
        userService.Register(user);
        return Result.success();
    }
    /**
     * 用户登录
     * @param loginParam
     * @return
     */
    /**
     * 获取用户名
     * @return
     */
    @GetMapping("/getUsername/{id}")
    public Result getUsername(@PathVariable Long id){
        return Result.success(userService.getUsername(id));
    }
    @PostMapping("/login")
    public Result  login(@RequestBody LoginParam loginParam) {
        log.info("用户登录：{}", loginParam);
        User info=userService.login(loginParam);
        if(info!=null)
            return Result.success(info);
        return Result.error("用户名或密码错误");
    }
    /**
     * 查询当前用户信息
     */
    @GetMapping("/findInfo/{id}")
    public Result findInfo(@PathVariable Long id){
        log.info("查询当前用户信息");
        User info = userService.findInfo(id);
        return Result.success(info);
    }

    /**
     * 修改用户信息
     */
    @PutMapping
    public Result update(@RequestBody User user){
        log.info("修改用户信息,参数:{}",user);
        userService.update(user);
        return Result.success();
    }
}


