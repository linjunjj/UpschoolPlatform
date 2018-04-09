package com.linjun.entity;

import java.io.Serializable;

/**
 * @author 林俊
 * @create 2018/3/18.
 * @desc
 **/
public class RentCategoryVo implements Serializable {
    private static final long serialVersionUID = 1L;
  private  Long id;
  private  String name;
  private  String keywords;
  private  String front_desc;
  private  Long parent_id;
  private  Integer sort_order;
  private  String show_index;
  private  byte is_show;
  private  String banner_url;
  private  String icon_url;
  private  String level;
  private  String front_name;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getFront_desc() {
        return front_desc;
    }

    public void setFront_desc(String front_desc) {
        this.front_desc = front_desc;
    }

    public Long getParent_id() {
        return parent_id;
    }

    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
    }

    public Integer getSort_order() {
        return sort_order;
    }

    public void setSort_order(Integer sort_order) {
        this.sort_order = sort_order;
    }

    public String getShow_index() {
        return show_index;
    }

    public void setShow_index(String show_index) {
        this.show_index = show_index;
    }

    public byte getIs_show() {
        return is_show;
    }

    public void setIs_show(byte is_show) {
        this.is_show = is_show;
    }

    public String getBanner_url() {
        return banner_url;
    }

    public void setBanner_url(String banner_url) {
        this.banner_url = banner_url;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getFront_name() {
        return front_name;
    }

    public void setFront_name(String front_name) {
        this.front_name = front_name;
    }
}
