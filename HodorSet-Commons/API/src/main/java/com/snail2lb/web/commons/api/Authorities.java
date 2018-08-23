package com.snail2lb.web.commons.api;

import java.util.Date;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author: lvbiao
 * @version: 1.0
 * @describe:
 * @date 2018-08-23 10:52:47
 */
public class Authorities implements GrantedAuthority {

    private static final long serialVersionUID = -6345851153042041840L;

    private Integer id;
    //名称
    private String authorityName;
    //授权标识
    private String authority;
    //创建时间
    private Date createTime;

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
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

    @Override
    public String getAuthority() {
        return this.authority;
    }
}