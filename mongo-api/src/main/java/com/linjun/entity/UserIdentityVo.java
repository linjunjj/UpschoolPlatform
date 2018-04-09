package com.linjun.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 林俊
 * @create 2018/3/15.
 * @desc
 **/
public class UserIdentityVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private  Long id;
    private  Long userId;
    private Long  identity_num;
    private  String identity_font;
    private  String identity_back;
    private byte status;
    private Date create_time;

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

    public Long getIdentity_num() {
        return identity_num;
    }

    public void setIdentity_num(Long identity_num) {
        this.identity_num = identity_num;
    }

    public String getIdentity_font() {
        return identity_font;
    }

    public void setIdentity_font(String identity_font) {
        this.identity_font = identity_font;
    }

    public String getIdentity_back() {
        return identity_back;
    }

    public void setIdentity_back(String identity_back) {
        this.identity_back = identity_back;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
