package com.linjun.service;

import com.linjun.entity.ScheduleJobEntity;
import com.linjun.entity.ScheduleJobLogEntity;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/10.
 * @desc
 **/
public interface ScheduleJobLogService {
    ScheduleJobLogEntity queryObject(Long jonId);
    List<ScheduleJobLogEntity> queryList(Map<String,Object> mao);
    int queryTotal(Map<String,Object> map);
    void save(ScheduleJobLogEntity log);
}
