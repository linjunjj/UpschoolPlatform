package com.linjun.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 林俊
 * @create 2018/3/19.
 * @desc
 **/
public class TaskMessageVo implements Serializable {
    private static final long serialVersionUID = 1L;
   private  Long id;
    private  Long userId;
    private  Long task_id;
    private  Long messager_id;
    private  Long ismessager_id;
    private  String context;
    private Date create_time;
    private  byte is_new;

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

    public Long getTask_id() {
        return task_id;
    }

    public void setTask_id(Long task_id) {
        this.task_id = task_id;
    }

    public Long getMessager_id() {
        return messager_id;
    }

    public void setMessager_id(Long messager_id) {
        this.messager_id = messager_id;
    }

    public Long getIsmessager_id() {
        return ismessager_id;
    }

    public void setIsmessager_id(Long ismessager_id) {
        this.ismessager_id = ismessager_id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public byte getIs_new() {
        return is_new;
    }

    public void setIs_new(byte is_new) {
        this.is_new = is_new;
    }
}
