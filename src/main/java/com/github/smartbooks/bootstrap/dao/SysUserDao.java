package com.github.smartbooks.bootstrap.dao;

import com.github.smartbooks.bootstrap.dao.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUserDao extends JpaRepository<SysUser, Integer> {

    SysUser find(String userName);

}
