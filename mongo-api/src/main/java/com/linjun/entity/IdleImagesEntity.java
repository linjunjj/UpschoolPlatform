package com.linjun.entity;

import java.io.Serializable;

/**
 * @author 林俊
 * @create 2018/3/18.
 * @desc
 **/
public class IdleImagesEntity implements Serializable {
    private static final long serialVersionUID = 1L;
   private Long id;
   private  Long userId;
   private  Long idle_id;
   private  String image_url;
   private  Integer sort_order;
   private  byte is_start;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getIdle_id() {
        return idle_id;
    }

    public void setIdle_id(Long idle_id) {
        this.idle_id = idle_id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Integer getSort_order() {
        return sort_order;
    }

    public void setSort_order(Integer sort_order) {
        this.sort_order = sort_order;
    }

    public byte getIs_start() {
        return is_start;
    }

    public void setIs_start(byte is_start) {
        this.is_start = is_start;
    }
}
