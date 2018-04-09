package com.linjun.service.impl;

import com.linjun.dao.ApiReportMapper;
import com.linjun.entity.ReportVo;
import com.linjun.service.ApiReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/25.
 * @desc
 **/
@Service("apiReportService")
public class ApiReportServiceImpl implements ApiReportService
{
    @Autowired
    private ApiReportMapper apiReportMapper;
    @Override
    public ReportVo queryObject(Long id) {
        return apiReportMapper.queryObject(id);
    }

    @Override
    public List<ReportVo> queryList(Map<String, Object> map) {
        return apiReportMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiReportMapper.queryTotal(map);
    }

    @Override
    public void save(ReportVo reportVo) {
    apiReportMapper.save(reportVo);
    }

    @Override
    public void update(ReportVo reportVo) {
    apiReportMapper.update(reportVo);
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
