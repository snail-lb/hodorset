package com.snail2lb.web.system.po;

import java.util.Date;import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author: lvbiao
 * @version: 1.0
 * @describe:
 * @date 2018-08-23 10:52:48
 */
@Table(name = "`sys_user`")
public class UserPO {
    //用户id
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "`id`")
    private Integer id;
    //角色id
    @Column(name = "`role_code`")
    private String roleCode;
    //账号
    @Column(name = "`username`")
    private String username;
    //密码
    @Column(name = "`password`")
    private String password;
    //昵称
    @Column(name = "`nick_name`")
    private String nickName;
    //头像
    @Column(name = "`avatar`")
    private String avatar;
    //性别
    @Column(name = "`sex`")
    private String sex;
    //手机号
    @Column(name = "`phone`")
    private String phone;
    //邮箱
    @Column(name = "`email`")
    private String email;
    //邮箱是否验证，0未验证，1已验证
    @Column(name = "`email_verified`")
    private Integer emailVerified;
    //状态，0正常，1冻结
    @Column(name = "`state`")
    private Integer state;
    //注册时间
    @Column(name = "`create_time`")
    private Date createTime;
    //修改时间
    @Column(name = "`update_time`")
    private Date updateTime;


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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
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

}