package com.github.smartbooks.bootstrap.dao;

import com.github.smartbooks.bootstrap.dao.entity.SysUser;

public interface SysUserDao {

    SysUser find(String userName);

}
