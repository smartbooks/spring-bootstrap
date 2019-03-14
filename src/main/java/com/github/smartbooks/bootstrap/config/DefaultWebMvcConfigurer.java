package com.github.smartbooks.bootstrap.config;

import com.github.smartbooks.bootstrap.interceptor.AuthorizationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@EnableWebMvc
@Configuration
public class DefaultWebMvcConfigurer implements WebMvcConfigurer {

    @Autowired
    private AuthorizationInterceptor authorizationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //注册一个拦截器
        registry.addInterceptor(authorizationInterceptor);


        //国际化语言检测
        {
            LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();

            localeChangeInterceptor.setParamName("language");

            registry.addInterceptor(localeChangeInterceptor);
        }

    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        //跨域请求支持,全局生效
        registry.addMapping("/rest")
                .allowedOrigins("bing.com", "google.com");

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //匹配静态资源
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/")
                .setCachePeriod(1);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //配置默认主页
        registry.addRedirectViewController("/", "/home/index");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    @Bean
    public LocaleResolver localeResolver() {

        //配置默认的国际化语言,后续的语言设置才能生效

        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();

        sessionLocaleResolver.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);

        return sessionLocaleResolver;
    }

}
