package com.snail2lb.web.test.po;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author: lvbiao
 * @version: 1.0
 * @describe:
 * @date 2018-08-20 19:50:26
 */
@Table(name = "`sys_custom_option`")
public class CustomOptionPO {
    
    @Id
    @Column(name = "`id`")
    private Integer id;
    
    @Column(name = "`name`")
    private String name;
    
    @Column(name = "`type`")
    private String type;
    
    @Column(name = "`description`")
    private String description;
    //默认的Echart结构
    @Column(name = "`option`")
    private String option;
    
    @Column(name = "`dataset`")
    private String dataset;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getDataset() {
        return dataset;
    }

    public void setDataset(String dataset) {
        this.dataset = dataset;
    }

}