package com.snail2lb.web.commons.api;

import java.io.Serializable;
import java.util.Date;
/**
 * @author: lvbiao
 * @version: 1.0
 * @describe:
 * @date 2018-08-23 10:52:48
 */
public class RoleAuthorities implements Serializable {

    private static final long serialVersionUID = -1357540253945834328L;

    private Integer id;
    //角色id
    private String roleCode;
    //权限id
    private String authority;
    //创建时间
    private Date createTime;
    
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