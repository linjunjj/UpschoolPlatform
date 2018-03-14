package com.linjun.entity;

import java.io.Serializable;

/**
 * @author 林俊
 * @create 2018/3/14.
 * @desc
 **/
public class UserDynamicEntity implements Serializable {
    private static final long serialVersionUID = 1L;
     private  Long id;
     private  Long userId;
     private  String address;
     private  String context;
     private  Long view;
     private  Long likesum;
     private  byte is_anonymous;
     private byte is_transpont;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Long getView() {
        return view;
    }

    public void setView(Long view) {
        this.view = view;
    }

    public Long getLikesum() {
        return likesum;
    }

    public void setLikesum(Long likesum) {
        this.likesum = likesum;
    }

    public byte getIs_anonymous() {
        return is_anonymous;
    }

    public void setIs_anonymous(byte is_anonymous) {
        this.is_anonymous = is_anonymous;
    }

    public byte getIs_transpont() {
        return is_transpont;
    }

    public void setIs_transpont(byte is_transpont) {
        this.is_transpont = is_transpont;
    }

    public byte getIs_start() {
        return is_start;
    }

    public void setIs_start(byte is_start) {
        this.is_start = is_start;
    }
}
