package com.linjun.entity;

import java.io.Serializable;

/**
 * @author 林俊
 * @create 2018/3/18.
 * @desc
 **/
public class IdleRalateVo implements Serializable {
    private static final long serialVersionUID = 1L;
   private  Long id;
   private  Long idle_id;
   private  Long idle_ralateid;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdle_id() {
        return idle_id;
    }

    public void setIdle_id(Long idle_id) {
        this.idle_id = idle_id;
    }

    public Long getIdle_ralateid() {
        return idle_ralateid;
    }

    public void setIdle_ralateid(Long idle_ralateid) {
        this.idle_ralateid = idle_ralateid;
    }
}
