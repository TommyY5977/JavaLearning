package com.itheima.filter;

import com.itheima.controller.ReportController;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

//@WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter {
    private static final Logger log = LoggerFactory.getLogger(ReportController.class);

    //初始化方法，web服务器启动的时候执行，只执行一次
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init 初始化方法 ...");
    }

    //拦截到请求之后，执行，会执行多次
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        log.info("拦截到了请求 ...");
        //放行
        filterChain.doFilter(servletRequest,servletResponse);
    }

    //销毁方法，web服务器关闭的时候执行，只执行一次
    @Override
    public void destroy() {
        log.info("destroy 销毁方法 ...");
    }
}
