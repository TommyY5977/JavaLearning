package com.itheima.interceptor;

import com.itheima.controller.ReportController;
import com.itheima.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

//@Component
public class TokenInterceptor implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(ReportController.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1. 获取到请求路径
        String requestURI = request.getRequestURI();

        //2. 判断是否是登录请求，如果路径中包含 /login，说明是登陆操作，放行
        if (requestURI.contains("/login")) {
            log.info("登录请求，放行");
            return true;
        }

        //3. 获取请求头中的token
        String token = request.getHeader("token");

        //4. 判断token是否存在，若不存在，说明用户未登录，返回错误信息（401状态码）
        if (token == null || token.isEmpty()) {
            log.info("令牌为空，响应401");
            response.setStatus(401);
            return false;
        }

        //5. 如果token存在，校验令牌，如果校验失败 -> 返回错误信息（401状态码）
        try {
            JwtUtils.parseToken(token);
        } catch (Exception e) {
            log.info("令牌非法，响应401");
            response.setStatus(401);
            return false;
        }

        log.info("令牌合法，放行");
        return true;
    }
}
