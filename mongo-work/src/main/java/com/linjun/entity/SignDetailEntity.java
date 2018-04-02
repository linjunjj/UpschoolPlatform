package com.linjun.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 林俊
 * @create 2018/3/18.
 * @desc
 **/
public class SignDetailEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private  Long id;
    private Long userId;
    private  Long signparise;
    private Date createTime;

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

    public Long getSignparise() {
        return signparise;
    }

    public void setSignparise(Long signparise) {
        this.signparise = signparise;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
