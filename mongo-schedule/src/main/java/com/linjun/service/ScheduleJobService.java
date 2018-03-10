package com.linjun.service;

import com.linjun.entity.ScheduleJobEntity;
import com.linjun.utils.ScheduleRunnable;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/10.
 * @desc
 **/
public interface ScheduleJobService {
    ScheduleJobEntity queryObject(Long jobId);
    List<ScheduleJobEntity> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(ScheduleJobEntity scheduleJobEntity);
    void update(ScheduleJobEntity scheduleJobEntity);
    int updateBatch(Long[] jobIds, int status);
    void deleteBatch(Long[] jobIds);
    void run(Long[] jobIds);
    void pause(Long[] jobIds);
    void resume(Long[] jobIds);
}
