package com.linjun.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 林俊
 * @create 2018/3/20.
 * @desc
 **/
public class SuggestEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long user_id;
    private String user_name;
    private  String suggest_title;
    private  String context;
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

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getSuggest_title() {
        return suggest_title;
    }

    public void setSuggest_title(String suggest_title) {
        this.suggest_title = suggest_title;
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
}
