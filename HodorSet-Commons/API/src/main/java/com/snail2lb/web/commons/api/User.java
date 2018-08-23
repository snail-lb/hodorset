package com.snail2lb.web.commons.api;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author: lvbiao
 * @version: 1.0
 * @describe:
 * @date 2018-08-23 10:52:48
 */
public class User implements UserDetails {
    private static final long serialVersionUID = 8938281672182838398L;
    //用户id
    private Integer id;
    //角色id
    private String roleCode;
    //账号
    private String username;
    //密码
    private String password;
    //昵称
    private String nickName;
    //头像
    private String avatar;
    //性别
    private String sex;
    //手机号
    private String phone;
    //邮箱
    private String email;
    //邮箱是否验证，0未验证，1已验证
    private Integer emailVerified;
    //状态，0正常，1冻结
    private Integer state;
    //注册时间
    private Date createTime;
    //修改时间
    private Date updateTime;
    //角色
    private Role role;
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

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public Integer getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(Integer emailVerified) {
        this.emailVerified = emailVerified;
    }
    
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setAuthorities(List<Authorities> authorities) {
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;  //账户是否未过期
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.state != 1;  //账户是否未锁定
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;  //凭证(密码)是否未过期
    }

    @Override
    public boolean isEnabled() {
        return true;  //用户是否启用
    }
}