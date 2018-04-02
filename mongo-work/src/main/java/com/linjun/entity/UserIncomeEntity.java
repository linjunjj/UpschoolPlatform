package com.linjun.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 林俊
 * @create 2018/3/15.
 * @desc
 **/
public class UserIncomeEntity implements Serializable {
    private static final long serialVersionUID = 1L;
   private  Long id;
   private  Long userId;
   private BigDecimal incomesum;
   private  BigDecimal incoem_detail;
   private byte status;
   private  String descripton;
   private Date add_time;

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

    public BigDecimal getIncomesum() {
        return incomesum;
    }

    public void setIncomesum(BigDecimal incomesum) {
        this.incomesum = incomesum;
    }

    public BigDecimal getIncoem_detail() {
        return incoem_detail;
    }

    public void setIncoem_detail(BigDecimal incoem_detail) {
        this.incoem_detail = incoem_detail;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public String getDescripton() {
        return descripton;
    }

    public void setDescripton(String descripton) {
        this.descripton = descripton;
    }

    public Date getAdd_time() {
        return add_time;
    }

    public void setAdd_time(Date add_time) {
        this.add_time = add_time;
    }
}
