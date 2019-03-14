package com.github.smartbooks.bootstrap.dao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SysUser implements Serializable {

    /**
     * 用户唯一标识
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 登陆账号
     */
    private String userName;

    /**
     * 账号密码
     */
    private String password;

    /**
     * 账号密码盐
     */
    private String passwordSalt;

    /**
     * 账户是否可用:true允许登录 false禁用登录
     */
    private boolean isAccountEnabled;

    /**
     * 账户是否未锁定:true账户解锁 false账户锁定
     */
    private boolean isAccountNonLocked;

    /**
     * 账户是否未过期:true未过期 false已过期
     */
    private boolean isAccountNonExpired;

    /**
     * 凭据是否未过期:true未过期 false已过期
     */
    private boolean isCredentialsNonExpired;

    /**
     * 账户角色列表
     */
    @OneToMany
    private List<SysRole> roleList = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public boolean isAccountEnabled() {
        return isAccountEnabled;
    }

    public void setAccountEnabled(boolean accountEnabled) {
        isAccountEnabled = accountEnabled;
    }

    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
    }

    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        isAccountNonExpired = accountNonExpired;
    }

    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        isCredentialsNonExpired = credentialsNonExpired;
    }

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }
}
