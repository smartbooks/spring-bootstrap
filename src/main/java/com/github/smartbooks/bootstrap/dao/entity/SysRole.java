package com.github.smartbooks.bootstrap.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 角色信息表
 */
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "roleCode")})
public class SysRole implements Serializable {

    /**
     * 角色唯一ID
     */
    @Id
    private Long id;

    /**
     * 角色唯一代码
     */
    private String roleCode;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色详细描述
     */
    private String summary;

    /**
     * 是否可用:0禁用状态 1正常可用
     */
    private Integer available;

    /**
     * 创建时间
     */
    private long createTime;

    /**
     * 角色权限清单
     */
    @OneToMany
    private List<SysPermission> permissionList = new ArrayList<>();

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public List<SysPermission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<SysPermission> permissionList) {
        this.permissionList = permissionList;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
