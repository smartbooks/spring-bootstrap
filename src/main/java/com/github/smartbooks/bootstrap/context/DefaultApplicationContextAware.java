package com.github.smartbooks.bootstrap.context;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 应用上下文容器扩展管理
 */
@Component
public class DefaultApplicationContextAware implements ApplicationContextAware {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        printApplicationContext(applicationContext);

    }


    private void printApplicationContext(ApplicationContext context) {

        logger.debug(String.format("id:%s disp_name:%s app_name:%s start_time:%s",
                context.getId(),
                context.getDisplayName(),
                context.getApplicationName(),
                context.getStartupDate()));

        String[] beanNames = context.getBeanDefinitionNames();

        for (String name : beanNames) {

            Object bean = context.getBean(name);

            logger.debug(String.format("bean:%s class:%s", name, bean));

        }

        ApplicationContext parentContext = context.getParent();

        if (null != parentContext) {

            printApplicationContext(parentContext);

        }

    }

}
