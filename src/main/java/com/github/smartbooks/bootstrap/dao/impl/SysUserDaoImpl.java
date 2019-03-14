package com.github.smartbooks.bootstrap.dao.impl;

import com.github.smartbooks.bootstrap.dao.SysUserDao;
import com.github.smartbooks.bootstrap.dao.entity.SysUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class SysUserDaoImpl implements SysUserDao {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public SysUser find(String userName) {
        return null;
    }

}
