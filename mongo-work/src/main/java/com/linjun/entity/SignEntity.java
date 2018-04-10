package com.linjun.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 林俊
 * @create 2018/3/18.
 * @desc
 **/
public class SignEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private  Long id;
    private  Long userId;
    private Long awardSum;
    private  Long singinSum;
    private  Long monSiginSum;
    private Date endsignTime;
    private  String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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

    public Long getAwardSum() {
        return awardSum;
    }

    public void setAwardSum(Long awardSum) {
        this.awardSum = awardSum;
    }

    public Long getSinginSum() {
        return singinSum;
    }

    public void setSinginSum(Long singinSum) {
        this.singinSum = singinSum;
    }

    public Long getMonSiginSum() {
        return monSiginSum;
    }

    public void setMonSiginSum(Long monSiginSum) {
        this.monSiginSum = monSiginSum;
    }

    public Date getEndsignTime() {
        return endsignTime;
    }

    public void setEndsignTime(Date endsignTime) {
        this.endsignTime = endsignTime;
    }
}
