package com.linjun.entity;

import java.io.Serializable;

/**
 * @author 林俊
 * @create 2018/10/4.
 * @desc
 **/
public class TopicPostionVo implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    private Long id;
    //位置名称
    private String name;
    //宽度
    private Integer width;
    //高度
    private Integer height;
    //描述
    private String desc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
