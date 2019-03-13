package com.github.smartbooks.bootstrap.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * 自定义过滤器
 */
@Component
public class TestFilter implements Filter {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public void init(FilterConfig filterConfig) {

        logger.debug("TestFilter.init");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        logger.debug("TestFilter.doFilter.begin");

        filterChain.doFilter(servletRequest, servletResponse);

        logger.debug("TestFilter.doFilter.end");

    }

    @Override
    public void destroy() {

        logger.debug("TestFilter.destroy");

    }

}
