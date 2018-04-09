package com.linjun.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 林俊
 * @create 2018/3/15.
 * @desc
 **/
public class UserStudentCardVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private  Long id;
    private  Long userId;
    private  String studentcard_font;
    private  String studentcard_back;
    private  byte status;
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

    public String getStudentcard_font() {
        return studentcard_font;
    }

    public void setStudentcard_font(String studentcard_font) {
        this.studentcard_font = studentcard_font;
    }

    public String getStudentcard_back() {
        return studentcard_back;
    }

    public void setStudentcard_back(String studentcard_back) {
        this.studentcard_back = studentcard_back;
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
