package com.github.smartbooks.bootstrap.interceptor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * 资源访问权限控制拦截器
 */
@Component
public class AuthorizationInterceptor implements HandlerInterceptor {

    private final String noSessionUrl = "/passport/login";
    private final String noPermissionUrl = "/passport/nopermission";
    private final String unAuthorizedUrl = "/passport/unauthorized";
    public final String sessionKey = "cur_user";
    public final String permissionKey = "sys_permission";

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        try {

            HttpSession httpSession = request.getSession();

            UserDetails userDetails = (UserDetails) httpSession.getAttribute(sessionKey);

            if (null == userDetails) {

                //用户未登陆
                response.sendRedirect(noSessionUrl);

                return false;
            }

            //CSRF拦截

            //用户当前权限清单
            Collection<GrantedAuthority> currentUserPermissionList = (Collection<GrantedAuthority>) userDetails.getAuthorities();

            if (null == currentUserPermissionList || currentUserPermissionList.size() < 1) {

                //拒绝,用户尚未分配权限
                response.sendRedirect(noPermissionUrl);

                return false;
            }

            //当前请求的URL地址
            String matchUrl = resolveRequestUrl(request.getRequestURI());

            //系统全部权限清单
            Map<String, Set<String>> sysPermissionMap = (Map<String, Set<String>>) request.getServletContext().getAttribute(permissionKey);

            //当前请求URL对应的权限清单
            Set<String> permissionSet = sysPermissionMap.get(matchUrl);

            if (null == permissionSet || permissionSet.size() < 1) {

                //通过,该资源无需权限
                return true;

            } else {

                for (GrantedAuthority grantedAuthority : currentUserPermissionList) {

                    if (permissionSet.contains(grantedAuthority.getAuthority())) {

                        //通过,用户拥有资源访问权限
                        return true;

                    }

                }

                //拒绝,没有访问权限
                response.sendRedirect(unAuthorizedUrl);

            }

        } catch (Exception e) {

            logger.error(e);

        }

        return false;
    }

    private String resolveRequestUrl(String url) {

        if (null == url || url.isEmpty()) {

            return "";

        }

        int pos = url.indexOf("?");

        if (pos != -1) {

            return url.substring(0, pos);

        }

        return url;
    }

}
