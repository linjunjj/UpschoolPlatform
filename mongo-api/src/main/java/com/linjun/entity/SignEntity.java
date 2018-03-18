package com.linjun.entity;

import java.io.Serializable;

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
    private  Long endsignTime;

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

    public Long getEndsignTime() {
        return endsignTime;
    }

    public void setEndsignTime(Long endsignTime) {
        this.endsignTime = endsignTime;
    }
}
