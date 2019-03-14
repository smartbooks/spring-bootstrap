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

            //默认角色
            Set<String> ignoreRole = AuthorizationInterceptor.ignorePermissionSet;

            //登录角色,继承默认角色
            Set<String> loginRole = new HashSet<>();
            loginRole.addAll(ignoreRole);
            loginRole.add("BASE");

            //管理角色,继承登录角色
            Set<String> adminRole = new HashSet<>();
            adminRole.addAll(loginRole);
            adminRole.add("ADMIN");

            //文档角色,继承登录角色
            Set<String> docRole = new HashSet<>();
            docRole.add("DOC");

            {
                //IGNORE 默认角色
                permissionMap.put("/passport/login", ignoreRole);
                permissionMap.put("/passport/unauthorized", ignoreRole);
                permissionMap.put("/passport/nopermission", ignoreRole);
                permissionMap.put("/passport/uninitpermission", ignoreRole);
                permissionMap.put("/error/index", ignoreRole);
                permissionMap.put("/error", ignoreRole);
                permissionMap.put("/", ignoreRole);
            }

            {
                //BASE 仅登录注销角色
                permissionMap.put("/profile/index", loginRole);
                permissionMap.put("/profile/modifyPassword", loginRole);
                permissionMap.put("/home/index", loginRole);
                permissionMap.put("/home/error", loginRole);
                permissionMap.put("/passport/loginoutok", loginRole);
            }

            {
                //ADMIN 系统管理员角色
                permissionMap.put("/root/sysuser/list", adminRole);
                permissionMap.put("/root/sysuser/view", adminRole);
                permissionMap.put("/root/sysuser/add", adminRole);
                permissionMap.put("/root/sysuser/del", adminRole);
                permissionMap.put("/root/sysuser/put", adminRole);
                permissionMap.put("/root/urlmapping/index", adminRole);
            }

            {
                //DOC 查看帮助文档角色
                permissionMap.put("/help/helpcenter/index", docRole);
            }

            servletContext.setAttribute(AuthorizationInterceptor.permissionKey, permissionMap);

        } catch (Exception e) {

            logger.error(e);

        }

    }

}
