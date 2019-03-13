package com.github.smartbooks.bootstrap.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Url授权失败时处理策略
 */
public class DefaultSimpleUrlAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private String defaultFailureUrl;

    public DefaultSimpleUrlAuthenticationFailureHandler(String defaultFailureUrl) {
        this.defaultFailureUrl = defaultFailureUrl;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {

        this.returnErrorPage(request, response, exception);

    }

    private void returnJson(HttpServletResponse response, AuthenticationException exception) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println("{\"ok\":0,\"msg\":\"" + exception.getLocalizedMessage() + "\"}");
    }

    private void returnErrorPage(HttpServletRequest request, HttpServletResponse response,
                                 AuthenticationException exception) throws IOException {

        request.getSession().setAttribute("page_error", exception.getLocalizedMessage());

        //request.getSession().setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, exception);

        response.sendRedirect(defaultFailureUrl);

    }

}