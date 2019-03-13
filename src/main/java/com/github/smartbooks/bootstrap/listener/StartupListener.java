package com.github.smartbooks.bootstrap.listener;

import com.github.smartbooks.bootstrap.interceptor.AuthorizationInterceptor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import java.util.*;

/**
 * 监听应用事件
 */
@Component
public class StartupListener implements ApplicationListener<ContextRefreshedEvent> {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        try {

            logger.debug("StartupListener.onApplicationEvent");

            WebApplicationContext webApplicationContext = (WebApplicationContext) event.getApplicationContext();

            ServletContext servletContext = webApplicationContext.getServletContext();

            Map<String, Set<String>> permissionMap = new HashMap<>();

            Set<String> ignoreRole = new HashSet<>();
            ignoreRole.add("IGNORE");

            Set<String> baseRole = new HashSet<>();
            baseRole.addAll(ignoreRole);
            baseRole.add("BASE");

            Set<String> docRole = new HashSet<>();
            docRole.add("DOC");

            Set<String> userRole = new HashSet<>();
            userRole.addAll(baseRole);
            userRole.add("ADMIN");

            {
                //DOC
                permissionMap.put("/help/helpcenter/index", docRole);
            }

            {
                //USER ALL
                permissionMap.put("/root/sysuser/list", userRole);
                permissionMap.put("/root/sysuser/view", userRole);
                permissionMap.put("/root/sysuser/add", userRole);
                permissionMap.put("/root/sysuser/del", userRole);
                permissionMap.put("/root/sysuser/put", userRole);
            }

            {
                //USER BASE
                permissionMap.put("/profile/index", baseRole);
                permissionMap.put("/profile/modifyPassword", baseRole);
                permissionMap.put("/home/index", baseRole);
                permissionMap.put("/home/error", baseRole);
                permissionMap.put("/passport/loginoutok", baseRole);
            }

            {
                //IGNORE
                permissionMap.put("/passport/login", ignoreRole);
                permissionMap.put("/passport/unauthorized", ignoreRole);
                permissionMap.put("/passport/nopermission", ignoreRole);
                permissionMap.put("/passport/uninitpermission", ignoreRole);
                permissionMap.put("/error/index", ignoreRole);
                permissionMap.put("/error", ignoreRole);
                permissionMap.put("/", ignoreRole);
            }

            servletContext.setAttribute(AuthorizationInterceptor.permissionKey, permissionMap);

        } catch (Exception e) {

            logger.error(e);

        }

    }

}
