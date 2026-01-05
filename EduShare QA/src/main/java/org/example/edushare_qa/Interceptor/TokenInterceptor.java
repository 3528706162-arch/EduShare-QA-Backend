package org.example.edushare_qa.Interceptor;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.example.edushare_qa.Utils.JwtUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*1.获取到请求路径
        String requestUri = request.getRequestURI();//资源访问路径:不包含协议、域名、端口号;如：/user/login

        //2.判断是否是登录请求，如果路径中包含/login,说明是登录操作,放行
        if (requestUri.contains("/login")) {
            log.info("登录操作");
            return true;
        }*/
        //3.获取请求头中的token
        String token = request.getHeader("token");

        //4.判断token是否存在,如果不存在说明用户没有登录，返回错误信息(响应401状态码)
        if (token == null || token.isEmpty()) {
            log.info("令牌为空,响应401");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);//响应状态码401
            return false;
        }

        //5.如果token存在校验令牌码，如果令牌码不正确，返回错误信息(响应401状态码)
        try {
            JwtUtils.parseJWT(token);
        } catch (Exception e) {
            log.info("令牌非法,响应401");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);//响应状态码401
            return  false;
        }
        //6.校验通过,放行
        log.info("令牌合法,放行");
        return true;
    }
}
