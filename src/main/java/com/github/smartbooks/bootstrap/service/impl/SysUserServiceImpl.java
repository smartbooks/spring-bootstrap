package com.github.smartbooks.bootstrap.service.impl;

import com.github.smartbooks.bootstrap.service.SysUserService;
import com.github.smartbooks.bootstrap.dao.SysUserDao;
import com.github.smartbooks.bootstrap.dao.entity.SysUser;
import com.github.smartbooks.bootstrap.service.BaseService;
import com.github.smartbooks.bootstrap.util.Paged;
import com.github.smartbooks.bootstrap.util.Paging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 注册一个服务组件
 */
@Service
public class SysUserServiceImpl extends BaseService implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public SysUser find(Long id) {

        SysUser a = new SysUser();
        a.setId(id);
        a.setUserName("admin");
        a.setPassword("123456");
        a.setUserCode("100");
        a.setSalt("FDEACB");

        return a;
    }

    @Override
    public SysUser find(String username) {

        return sysUserDao.find(username);

    }

    @Override
    public void create(SysUser entity) {

    }

    @Override
    public void update(Long id, SysUser entity) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Paged<SysUser> list(Paging paging) {

        Paged<SysUser> result = new Paged<>();

        result.setPageIndex(paging.getPageIndex());

        result.setPageSize(paging.getPageSize());

        try {

            //随机生成一些数据
            for (int i = 0; i < paging.getPageSize(); i++) {

                SysUser a = new SysUser();
                a.setId(System.nanoTime());
                a.setUserName("admin");
                a.setPassword("123456");
                a.setUserCode("100");
                a.setSalt("FDEACB");

                result.getData().add(a);
            }

            result.setSizeCount(10000L);

        } catch (Exception e) {
            logger.error(e);
        }

        return result;
    }


}
