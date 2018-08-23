package com.snail2lb.web.commons.api;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * @author: lvbiao
 * @version: 1.0
 * @describe:
 * @date 2018-08-23 10:52:48
 */
public class Role  implements Serializable {
    private static final long serialVersionUID = 3746930240174935200L;
    //角色ID
    private Integer id;
    //角色code
    private String roleCode;
    //角色名称
    private String roleName;
    //备注
    private String comments;
    //是否删除，0否，1是
    private Integer isDelete;
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;
    //权限
    private List<Authorities> authorities;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
    
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
    
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
    
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public List<Authorities> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authorities> authorities) {
        this.authorities = authorities;
    }
}