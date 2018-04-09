package com.linjun.entity;

import java.io.Serializable;

/**
 * @author 林俊
 * @create 2018/4/9.
 * @desc
 **/
public class SearchHistoryEntity implements Serializable {
    private static final long serialVersionUID = 1L;
     private  Integer id;
     private  String keyword;
     private  String from;
     private  Integer add_time;
     private  String user_id;
   private  String user_name;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Integer getAdd_time() {
        return add_time;
    }

    public void setAdd_time(Integer add_time) {
        this.add_time = add_time;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
