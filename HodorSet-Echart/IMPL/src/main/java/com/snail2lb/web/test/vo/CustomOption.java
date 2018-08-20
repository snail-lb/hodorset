package com.snail2lb.web.test.vo;

/**
 * @author: lvbiao
 * @version: 1.0
 * @describe:
 * @date 2018-08-20 19:50:25
 */
public class CustomOption {
    
    private Integer id;
    
    private String name;
    
    private String type;
    
    private String description;
    //默认的Echart结构
    private String option;
    
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