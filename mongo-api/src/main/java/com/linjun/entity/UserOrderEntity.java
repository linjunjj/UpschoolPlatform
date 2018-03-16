package com.linjun.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 林俊
 * @create 2018/3/16.
 * @desc
 **/
public class UserOrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private  Long id;
    private  Long userId;
    private BigDecimal price;
    private Date create_time;
    private  String order_su;
    private  Date pay_time;
    private  Date cancel_time;
    private  Date send_time;
    private  Date comlete_time;
    private  String logistics;
    private  String logisticscode;
    private  byte is_pay;
    private  Integer type;
    private  String descripton;
    private  String country;
    private  String province;
    private  String city;
    private  String district;
    private  String address;
    private  String shipping_no;
    private  String consignee;

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getOrder_su() {
        return order_su;
    }

    public void setOrder_su(String order_su) {
        this.order_su = order_su;
    }

    public Date getPay_time() {
        return pay_time;
    }

    public void setPay_time(Date pay_time) {
        this.pay_time = pay_time;
    }

    public Date getCancel_time() {
        return cancel_time;
    }

    public void setCancel_time(Date cancel_time) {
        this.cancel_time = cancel_time;
    }

    public Date getSend_time() {
        return send_time;
    }

    public void setSend_time(Date send_time) {
        this.send_time = send_time;
    }

    public Date getComlete_time() {
        return comlete_time;
    }

    public void setComlete_time(Date comlete_time) {
        this.comlete_time = comlete_time;
    }

    public String getLogistics() {
        return logistics;
    }

    public void setLogistics(String logistics) {
        this.logistics = logistics;
    }

    public String getLogisticscode() {
        return logisticscode;
    }

    public void setLogisticscode(String logisticscode) {
        this.logisticscode = logisticscode;
    }

    public byte getIs_pay() {
        return is_pay;
    }

    public void setIs_pay(byte is_pay) {
        this.is_pay = is_pay;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDescripton() {
        return descripton;
    }

    public void setDescripton(String descripton) {
        this.descripton = descripton;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getShipping_no() {
        return shipping_no;
    }

    public void setShipping_no(String shipping_no) {
        this.shipping_no = shipping_no;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }
}
