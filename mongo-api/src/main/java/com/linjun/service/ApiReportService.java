package com.linjun.service;

import com.linjun.entity.ReportVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/25.
 * @desc
 **/

public interface ApiReportService {
    ReportVo queryObject(Long id);
    List<ReportVo> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(ReportVo reportVo);
    void update(ReportVo reportVo);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
