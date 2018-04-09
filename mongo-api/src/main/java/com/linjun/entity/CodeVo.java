package com.linjun.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * @author 林俊
 * @create 2018/3/14.
 * @desc
 **/
public class CodeVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private  String code;
    private  String email;
    private String mobile;
    private Date expire_time;
    private  byte is_user;
    private byte code_type;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getExpire_time() {
        return expire_time;
    }

    public void setExpire_time(Date expire_time) {
        this.expire_time = expire_time;
    }

    public byte getIs_user() {
        return is_user;
    }

    public void setIs_user(byte is_user) {
        this.is_user = is_user;
    }

    public byte getCode_type() {
        return code_type;
    }

    public void setCode_type(byte code_type) {
        this.code_type = code_type;
    }
}
