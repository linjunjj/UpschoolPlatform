package com.linjun.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 林俊
 * @create 2018/3/19.
 * @desc
 **/
public class PartTimeApplyVolumVo implements Serializable {
    private static final long serialVersionUID = 1L;
  private  Long id;
  private  Long parttime_id;
  private  Long apply_id;
  private  String user_name;
  private Date apply_time;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParttime_id() {
        return parttime_id;
    }

    public void setParttime_id(Long parttime_id) {
        this.parttime_id = parttime_id;
    }

    public Long getApply_id() {
        return apply_id;
    }

    public void setApply_id(Long apply_id) {
        this.apply_id = apply_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Date getApply_time() {
        return apply_time;
    }

    public void setApply_time(Date apply_time) {
        this.apply_time = apply_time;
    }
}
