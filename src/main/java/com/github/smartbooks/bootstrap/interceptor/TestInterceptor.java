package com.github.smartbooks.bootstrap.interceptor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 自定义拦截器
 */
@Component
public class TestInterceptor implements HandlerInterceptor {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        //请求发送到控制器之前执行操作
        //ParameterizableViewController [view="/home/index"]
        logger.debug("TestInterceptor.preHandle");

        HttpSession httpSession = request.getSession();

        UserDetails userDetails = (UserDetails) httpSession.getAttribute("user");

        if (null == userDetails) {

            response.sendRedirect("/passport/login?nosession");

            return false;

        }

        //CSRF拦截
        

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

        //响应发送到客户端之前执行操作
        logger.debug("TestInterceptor.postHandle");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        //完成请求和响应后执行操作
        logger.debug("TestInterceptor.afterCompletion");

    }
}
