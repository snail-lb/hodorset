package com.snail2lb.web.echart.api;

/**
 * @autor: lvbiao
 * @version: 1.0
 * @descript: 系统默认的echart结构
 * @date: 2018-08-12 17:48
 */
public class CustomOption {
    private Integer id;
    private String name;
    private String type;
    private String description;
    private String option;

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
}
