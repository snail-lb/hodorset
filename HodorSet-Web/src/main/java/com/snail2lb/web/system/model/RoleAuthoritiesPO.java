package com.snail2lb.web.system.model;

import java.util.Date;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="sys_role_authorities")
public class RoleAuthoritiesPO {
    @Id
    private String id;

    private String roleId;

    private String authority;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}