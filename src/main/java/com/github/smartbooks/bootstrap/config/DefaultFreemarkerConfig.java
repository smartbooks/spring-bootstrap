package com.github.smartbooks.bootstrap.config;

import com.github.smartbooks.bootstrap.template.PageNumberDirective;
import freemarker.template.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 注入自定义模板指令
 */
@Component
public class DefaultFreemarkerConfig {

    @Autowired
    private Configuration configuration;

    @Autowired
    private PageNumberDirective pageNumberDirective;

    @PostConstruct
    public void setSharedVarialble() {

        configuration.setSharedVariable(pageNumberDirective.getTagName(), pageNumberDirective);

    }

}
