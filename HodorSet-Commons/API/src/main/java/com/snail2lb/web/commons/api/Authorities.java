package com.snail2lb.web.commons.api;

import java.util.Date;

import org.springframework.security.core.GrantedAuthority;

public class Authorities implements GrantedAuthority {
    private static final long serialVersionUID = -6058060376656180793L;

    private String authority;

    private String authorityName;

    private Date createTime;

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

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
