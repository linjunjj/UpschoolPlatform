package com.linjun.service.impl;

import com.linjun.dao.ScheduleJobLogDao;
import com.linjun.entity.ScheduleJobLogEntity;
import com.linjun.service.ScheduleJobLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/10.
 * @desc
 **/
@Service("scheduleJobLogService")
public class ScheduleJobLogServiceImpl implements ScheduleJobLogService {
    @Autowired
    private ScheduleJobLogDao scheduleJobLogDao;

    @Override
    public ScheduleJobLogEntity queryObject(Long jonId) {
        return scheduleJobLogDao.queryObject(jonId);
    }

    @Override
    public List<ScheduleJobLogEntity> queryList(Map<String, Object> map) {
        return scheduleJobLogDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return scheduleJobLogDao.queryTotal(map);
    }

    @Override
    public void save(ScheduleJobLogEntity log) {
        scheduleJobLogDao.save(log);
    }
}
