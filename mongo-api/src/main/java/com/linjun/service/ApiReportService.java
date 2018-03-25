package com.linjun.service;

import com.linjun.entity.ReportEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/25.
 * @desc
 **/
@Service
public interface ApiReportService {
    ReportEntity queryObject(Integer id);
    List<ReportEntity> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(ReportEntity reportEntity);
    void update(ReportEntity reportEntity);
    void delete(Integer id);
    void deleteBatch(Integer[] ids);

}
