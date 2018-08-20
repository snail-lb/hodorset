package com.snail2lb.web.system.model;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;



@Table(name="sys_authorities")
public class AuthoritiesPO{
    @Id
    private String authority;

    private String authorityName;

    private Date createTime;

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
