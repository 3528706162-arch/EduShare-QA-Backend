package org.example.edushare_qa.Config;

import org.example.edushare_qa.Interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration//配置类
public class WebConfig implements WebMvcConfigurer {
//    @Autowired
//    private DemoInterceptor demoInterceptor;
    @Autowired
    private TokenInterceptor tokenInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/**")//拦截所有请求
                .excludePathPatterns("/api/v1/user/Register")//注册请求不拦截
                .excludePathPatterns("/api/v1/user/login");//登录请求不拦截
    }
}
