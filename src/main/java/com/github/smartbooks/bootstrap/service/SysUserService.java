package com.github.smartbooks.bootstrap.service;

import com.github.smartbooks.bootstrap.dao.entity.SysUser;
import com.github.smartbooks.bootstrap.util.Paged;
import com.github.smartbooks.bootstrap.util.Paging;

/**
 * 服务组件接口
 */
public interface SysUserService {

    SysUser find(Long id);

    SysUser find(String username);

    void create(SysUser entity);

    void update(Long id, SysUser entity);

    void delete(Long id);

    Paged<SysUser> list(Paging paging);

}
