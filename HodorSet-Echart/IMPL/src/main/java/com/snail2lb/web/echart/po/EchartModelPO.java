package com.snail2lb.web.echart.po;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author: lvbiao
 * @version: 1.0
 * @describe:
 * @date 2018-08-21 18:33:22
 */
@Table(name = "`sys_echart_model`")
public class EchartModelPO {
    
    @Id
    @Column(name = "`id`")
    private Integer id;
    
    @Column(name = "`name`")
    private String name;
    
    @Column(name = "`group`")
    private String group;
    
    @Column(name = "`type`")
    private String type;
    
    @Column(name = "`data_url`")
    private String dataUrl;
    
    @Column(name = "`data_interface`")
    private String dataInterface;
    
    @Column(name = "`data_request_method`")
    private String dataRequestMethod;
    
    @Column(name = "`data_type`")
    private String dataType;
    
    @Column(name = "`interval`")
    private Integer interval;
    
    @Column(name = "`option`")
    private String option;
    
    @Column(name = "`layui_col_md`")
    private Integer layuiColMd;
    
    @Column(name = "`layui_col_md_offset`")
    private Integer layuiColMdOffset;
    
    @Column(name = "`height`")
    private Integer height;
    
    @Column(name = "`order`")
    private Integer order;


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

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDataUrl() {
        return dataUrl;
    }

    public void setDataUrl(String dataUrl) {
        this.dataUrl = dataUrl;
    }

    public String getDataInterface() {
        return dataInterface;
    }

    public void setDataInterface(String dataInterface) {
        this.dataInterface = dataInterface;
    }

    public String getDataRequestMethod() {
        return dataRequestMethod;
    }

    public void setDataRequestMethod(String dataRequestMethod) {
        this.dataRequestMethod = dataRequestMethod;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public Integer getLayuiColMd() {
        return layuiColMd;
    }

    public void setLayuiColMd(Integer layuiColMd) {
        this.layuiColMd = layuiColMd;
    }

    public Integer getLayuiColMdOffset() {
        return layuiColMdOffset;
    }

    public void setLayuiColMdOffset(Integer layuiColMdOffset) {
        this.layuiColMdOffset = layuiColMdOffset;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

}