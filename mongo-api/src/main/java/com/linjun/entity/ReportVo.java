package com.linjun.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 林俊
 * @create 2018/3/20.
 * @desc
 **/
public class ReportVo implements Serializable {
    private static final long serialVersionUID = 1L;
   private Long id;
   private  Long is_reportid;
   private  Long reportid;
   private  byte report_type;
   private  String report_reason;
   private  String report_fujia;
   private  byte status;
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

    public Long getIs_reportid() {
        return is_reportid;
    }

    public void setIs_reportid(Long is_reportid) {
        this.is_reportid = is_reportid;
    }

    public Long getReportid() {
        return reportid;
    }

    public void setReportid(Long reportid) {
        this.reportid = reportid;
    }

    public byte getReport_type() {
        return report_type;
    }

    public void setReport_type(byte report_type) {
        this.report_type = report_type;
    }

    public String getReport_reason() {
        return report_reason;
    }

    public void setReport_reason(String report_reason) {
        this.report_reason = report_reason;
    }

    public String getReport_fujia() {
        return report_fujia;
    }

    public void setReport_fujia(String report_fujia) {
        this.report_fujia = report_fujia;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
