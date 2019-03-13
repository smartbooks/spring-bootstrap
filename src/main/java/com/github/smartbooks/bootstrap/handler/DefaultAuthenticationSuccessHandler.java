package com.github.smartbooks.bootstrap.handler;

import com.github.smartbooks.bootstrap.interceptor.AuthorizationInterceptor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.ForwardAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 用户登录授权成功
 */
public class DefaultAuthenticationSuccessHandler extends ForwardAuthenticationSuccessHandler {

    public DefaultAuthenticationSuccessHandler(String forwardUrl) {
        super(forwardUrl);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        HttpSession httpSession = request.getSession();

        User user = new User("admin", "123456", authentication.getAuthorities());

        httpSession.setAttribute(AuthorizationInterceptor.sessionKey, user);

        super.onAuthenticationSuccess(request, response, authentication);
    }

}
