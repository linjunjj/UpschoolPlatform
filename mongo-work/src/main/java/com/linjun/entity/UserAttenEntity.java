package com.linjun.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 林俊
 * @create 2018/3/15.
 * @desc
 **/
public class UserAttenEntity  implements Serializable{
    private static final long serialVersionUID = 1L;
   private Long id;
   private Long userId;
   private Long isUserId;
   private Date createTime;
   private byte isMutual;
   private  byte isNew;

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

    public Long getIsUserId() {
        return isUserId;
    }

    public void setIsUserId(Long isUserId) {
        this.isUserId = isUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public byte getIsMutual() {
        return isMutual;
    }

    public void setIsMutual(byte isMutual) {
        this.isMutual = isMutual;
    }

    public byte getIsNew() {
        return isNew;
    }

    public void setIsNew(byte isNew) {
        this.isNew = isNew;
    }
}
