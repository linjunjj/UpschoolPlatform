package com.linjun.service.impl;

import com.linjun.dao.ReportMapper;
import com.linjun.entity.ReportEntity;
import com.linjun.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/4.
 * @desc
 **/
@Service("reportService")
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportMapper reportMapper;
    @Override
    public ReportEntity queryObject(Long id) {
        return reportMapper.queryObject(id);
    }

    @Override
    public List<ReportEntity> queryList(Map<String, Object> map) {
        return reportMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return reportMapper.queryTotal(map);
    }

    @Override
    public void save(ReportEntity reportEntity) {
   reportMapper.save(reportEntity);
    }

    @Override
    public void update(ReportEntity reportEntity) {
      reportMapper.update(reportEntity);
    }

    @Override
    public void delete(Long id) {
   reportMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
   reportMapper.deleteBatch(ids);
    }
}
