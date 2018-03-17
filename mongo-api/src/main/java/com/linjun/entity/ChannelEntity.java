package com.linjun.entity;

import java.io.Serializable;

/**
 * @author 林俊
 * @create 2018/3/17.
 * @desc
 **/
public class ChannelEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private  Integer id;
    private  String name;
    private  String url;
    private  String icon_url;
    private  Integer sort_order;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    public Integer getSort_order() {
        return sort_order;
    }

    public void setSort_order(Integer sort_order) {
        this.sort_order = sort_order;
    }
}
