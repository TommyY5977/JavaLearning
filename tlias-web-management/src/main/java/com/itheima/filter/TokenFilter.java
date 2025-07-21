package com.itheima.filter;

import com.itheima.controller.ReportController;
import com.itheima.utils.CurrentHolder;
import com.itheima.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class TokenFilter implements Filter {
    private static final Logger log = LoggerFactory.getLogger(ReportController.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //1. 获取请求路径
        String requestURI = request.getRequestURI();

        //2. 判断是否为登录请求,若为登录请求直接放行
        if (requestURI.contains("/login")) {
            log.info("登录请求，放行");
            filterChain.doFilter(request, response);
            return;
        }

        //3. 若非登录请求，获取token信息
        String token = request.getHeader("token");

        //4. 判断token是否存在，若不存在说明用户未登录，返回401状态码
        if (token == null || token.equals("")) {
            log.info("令牌为空，响应401");
            response.setStatus(401);
            return;
        }

        //5. 如果令牌存在，校验令牌，如果校验失败->返回错误信息（401状态码）
        try {
            Claims claims = JwtUtils.parseToken(token);
            Integer empId = Integer.valueOf(claims.get("id").toString());
            CurrentHolder.setCurrentId(empId);
            log.info("当前登录员工ID：{}，将其存入ThreadLocal中", empId);
        } catch (Exception e) {
            log.info("令牌非法，响应401");
            response.setStatus(401);
            return;
        }

        //6. 无误放行
        log.info("令牌无误，放行");
        filterChain.doFilter(request, response);

        //删除ThreadLocal中的数据
        CurrentHolder.remove();
    }
}
