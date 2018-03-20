package com.linjun.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 林俊
 * @create 2018/3/20.
 * @desc
 **/
public class InviteCodeEntity implements Serializable {
    private static final long serialVersionUID = 1L;
  private  Long id;
  private  Long user_id;
  private  byte is_multi;
  private Date start_time;
  private  Date edd_time;

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

    public byte getIs_multi() {
        return is_multi;
    }

    public void setIs_multi(byte is_multi) {
        this.is_multi = is_multi;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEdd_time() {
        return edd_time;
    }

    public void setEdd_time(Date edd_time) {
        this.edd_time = edd_time;
    }
}
