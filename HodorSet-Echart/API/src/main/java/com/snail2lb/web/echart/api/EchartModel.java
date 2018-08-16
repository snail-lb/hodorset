package com.snail2lb.web.echart.api;


import org.springframework.web.bind.annotation.RequestMethod;

import com.snail2lb.web.echart.api.emuns.DataTypeEmun;

/**
 * @autor: lvbiao
 * @version: 1.0
 * @descript:
 * @date: 2018-08-12 11:49
 */
public class EchartModel {
    private Integer id;
    private String name;
    private String group;
    //图形种类
    private String type;
    //数据接口主要存储获取数据的接口 不填的话默认为本系统中去数据 http://localhost:8088/
    private String dataUrl;
    //数据接口主要存储获取数据的接口   如：echart/data
    private String dataInterface;
    //数据请求方法  默认GET
    private RequestMethod dataRequestMethod;
    //dataset 的数据结构  默认DATASET_MAP
    private DataTypeEmun dataType;
    //数据刷新频率  单位毫秒 默认0，只会加载一次
    private Integer interval;
    //option结构
    private String option;
    //布局宽度 1-12 默认4
    private Integer layuiColMd;
    //偏移量 默认空，用于调整图形在一行中的偏移位置 默认0
    private Integer layuiColMdOffset;
    //图形高度，默认400px
    private Integer height;
    //在该组中所有图形中的排列顺序
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
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

    public RequestMethod getDataRequestMethod() {
        return dataRequestMethod;
    }

    public void setDataRequestMethod(RequestMethod dataRequestMethod) {
        this.dataRequestMethod = dataRequestMethod;
    }

    public DataTypeEmun getDataType() {
        return dataType;
    }

    public void setDataType(DataTypeEmun dataType) {
        this.dataType = dataType;
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

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }
}
