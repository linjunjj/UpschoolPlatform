package com.linjun.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 林俊
 * @create 2018/4/11.
 * @desc
 **/
public class InviteRecordEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private  Long id;
    private  Long userId;
    private  String username;
    private  Long isUserId;
    private   String isUserName;
    private Date add_time;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getIsUserId() {
        return isUserId;
    }

    public void setIsUserId(Long isUserId) {
        this.isUserId = isUserId;
    }

    public String getIsUserName() {
        return isUserName;
    }

    public void setIsUserName(String isUserName) {
        this.isUserName = isUserName;
    }

    public Date getAdd_time() {
        return add_time;
    }

    public void setAdd_time(Date add_time) {
        this.add_time = add_time;
    }
}
