package com.github.smartbooks.bootstrap.dao.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 权限信息表
 */
@Entity
public class SysPermission implements Serializable {

    /**
     * 权限唯一标识
     */
    @Id
    private Long id;

    /**
     * 权限资源名称
     */
    private String name;

    /**
     * 权限详细描述
     */
    private String describe;

    /**
     * 权限类型:0链接节点 1文本节点
     */
    private Integer type;

    /**
     * 资源地址
     */
    private String url;

    /**
     * 资源图标
     */
    private String icon;

    /**
     * 统计排序
     */
    private Integer sort;

    /**
     * 父级权限:0根节点
     */
    private Long parentId;

    /**
     * 是否可用:0禁用状态 1正常可用
     */
    private Integer available;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }
}
