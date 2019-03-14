package com.github.smartbooks.bootstrap.support;

import com.github.smartbooks.bootstrap.dao.entity.SysRole;
import com.github.smartbooks.bootstrap.dao.entity.SysUser;
import com.github.smartbooks.bootstrap.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户授权详情服务
 */
@Service
public class DefaultUserDetailsService implements UserDetailsService {

    /**
     * 自动装配用户服务
     */
    @Autowired
    private SysUserService sysUserService;

    /**
     * 重写授权时用户资料查询方法
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        /*
        SysUser sysUser = sysUserService.find(username);

        if (null == sysUser) {

            throw new UsernameNotFoundException(username);

        }
        */

        SysUser sysUser = new SysUser();

        sysUser.setUserName("admin");
        sysUser.setId(1L);
        sysUser.setPassword("$2a$10$KNBUMuT5Jd7ZMrLTvRPvB.81.yqVzg2761/LB8gfGJtngjFGKhvZO"); //123456

        {
            SysRole sysRole = new SysRole();
            sysRole.setId(1L);
            sysRole.setRoleName("Administrator");
            sysRole.setRoleCode("ADMIN");
            sysUser.getRoleList().add(sysRole);
        }

        {
            SysRole sysRole = new SysRole();
            sysRole.setId(1L);
            sysRole.setRoleName("Base Account");
            sysRole.setRoleCode("BASE");
            sysUser.getRoleList().add(sysRole);
        }

        {
            SysRole sysRole = new SysRole();
            sysRole.setId(1L);
            sysRole.setRoleName("Document");
            sysRole.setRoleCode("DOC");
            sysUser.getRoleList().add(sysRole);
        }

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (SysRole role : sysUser.getRoleList()) {

            authorities.add(new SimpleGrantedAuthority(role.getRoleCode()));

        }

        return new User(sysUser.getUserName(), sysUser.getPassword(), authorities);
    }

}
