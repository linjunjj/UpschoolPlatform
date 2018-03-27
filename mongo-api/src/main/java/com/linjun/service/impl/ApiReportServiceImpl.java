package com.linjun.service.impl;

import com.linjun.dao.ApiReportMapper;
import com.linjun.entity.ReportEntity;
import com.linjun.service.ApiReportService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/25.
 * @desc
 **/
public class ApiReportServiceImpl implements ApiReportService
{
    @Autowired
    private ApiReportMapper apiReportMapper;
    @Override
    public ReportEntity queryObject(Long id) {
        return apiReportMapper.queryObject(id);
    }

    @Override
    public List<ReportEntity> queryList(Map<String, Object> map) {
        return apiReportMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiReportMapper.queryTotal(map);
    }

    @Override
    public void save(ReportEntity reportEntity) {
    apiReportMapper.save(reportEntity);
    }

    @Override
    public void update(ReportEntity reportEntity) {
    apiReportMapper.update(reportEntity);
    }

    @Override
    public void delete(Long id) {
    apiReportMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
      apiReportMapper.deleteBatch(ids);
    }
}
