package com.linjun.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 林俊
 * @create 2018/3/19.
 * @desc
 **/
public class TaskVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private  Long id;
    private  Long userId;
    private  String title;
    private  String address;
    private  String context;
    private BigDecimal price;
    private  Long view_quality;
    private  Long like_quality;
    private  byte status;
    private  Long category_id;
    private Date create_time;
    private  Float jingdu;
    private  Float weidu;

    public Float getJingdu() {
        return jingdu;
    }

    public void setJingdu(Float jingdu) {
        this.jingdu = jingdu;
    }

    public Float getWeidu() {
        return weidu;
    }

    public void setWeidu(Float weidu) {
        this.weidu = weidu;
    }

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getView_quality() {
        return view_quality;
    }

    public void setView_quality(Long view_quality) {
        this.view_quality = view_quality;
    }

    public Long getLike_quality() {
        return like_quality;
    }

    public void setLike_quality(Long like_quality) {
        this.like_quality = like_quality;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
