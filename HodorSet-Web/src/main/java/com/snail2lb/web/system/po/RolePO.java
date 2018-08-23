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
@Table(name = "`sys_role`")
public class RolePO {
    //角色ID
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "`id`")
    private Integer id;
    //角色code
    @Column(name = "`role_code`")
    private String roleCode;
    //角色名称
    @Column(name = "`role_name`")
    private String roleName;
    //备注
    @Column(name = "`comments`")
    private String comments;
    //是否删除，0否，1是
    @Column(name = "`is_delete`")
    private Integer isDelete;
    //创建时间
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

}