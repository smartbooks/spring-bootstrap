package com.github.smartbooks.bootstrap.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Url授权失败时处理策略
 */
@Component
public class DefaultSimpleUrlAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    /**
     * 授权失败执行
     *
     * @param request
     * @param response
     * @param exception
     * @throws IOException
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {

        this.returnErrorPage(request, response, exception);

    }


    /**
     * 直接返回需要返回的 json 数据
     */
    private void returnJson(HttpServletResponse response, AuthenticationException exception) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println("{\"ok\":0,\"msg\":\"" + exception.getLocalizedMessage() + "\"}");
    }

    /**
     * 直接返会错误页面
     */
    private void returnErrorPage(HttpServletRequest request, HttpServletResponse response,
                                 AuthenticationException exception) throws IOException {

        String strUrl = request.getContextPath() + "/passport/login";

        request.getSession().setAttribute("page_error", exception.getLocalizedMessage());

        request.getSession().setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, exception);

        response.sendRedirect(strUrl);

    }
}
