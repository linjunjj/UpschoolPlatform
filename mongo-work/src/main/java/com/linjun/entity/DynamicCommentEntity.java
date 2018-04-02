package com.linjun.entity;

import java.io.Serializable;

/**
 * @author 林俊
 * @create 2018/3/17.
 * @desc
 **/
public class DynamicCommentEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long userId;
    private  Long dynamicid;
    private  String context;
    private  String add_time;
    private  Long is_userid;
    private  byte is_start;
    private  byte status;
    private byte is_new;

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

    public Long getDynamicid() {
        return dynamicid;
    }

    public void setDynamicid(Long dynamicid) {
        this.dynamicid = dynamicid;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    public Long getIs_userid() {
        return is_userid;
    }

    public void setIs_userid(Long is_userid) {
        this.is_userid = is_userid;
    }

    public byte getIs_start() {
        return is_start;
    }

    public void setIs_start(byte is_start) {
        this.is_start = is_start;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public byte getIs_new() {
        return is_new;
    }

    public void setIs_new(byte is_new) {
        this.is_new = is_new;
    }
}
