package com.linjun.service.impl;

import com.linjun.dao.ScheduleJobDao;
import com.linjun.entity.ScheduleJobEntity;
import com.linjun.service.ScheduleJobService;
import com.linjun.utils.Constant;
import com.linjun.utils.ScheduleRunnable;
import com.linjun.utils.ScheduleUtils;
import org.quartz.CronTrigger;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/10.
 * @desc
 **/
@Service("scheduleJobService")
public class ScheduleJobServiceImpl implements ScheduleJobService {
    @Autowired
    private Scheduler scheduler;
    @Autowired
  private   ScheduleJobDao scheduleJobDao;
    @PostConstruct
    public  void init(){
        List<ScheduleJobEntity> scheduleJobEntityList=scheduleJobDao.queryList(new HashMap<>());
        for (ScheduleJobEntity scheduleJob:
             scheduleJobEntityList) {
            CronTrigger cronTrigger= ScheduleUtils.getCronTrigger(scheduler,scheduleJob.getJobId());
          if (cronTrigger==null){
              ScheduleUtils.createScheduleJob(scheduler,scheduleJob);
          }else {
              ScheduleUtils.updateScheduleJob(scheduler,scheduleJob);
          }
        }
    }

    @Override
    public ScheduleJobEntity queryObject(Long jobId) {
        return scheduleJobDao.queryObject(jobId);
    }

    @Override
    public List<ScheduleJobEntity> queryList(Map<String, Object> map) {
        return scheduleJobDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return scheduleJobDao.queryTotal(map);
    }

    @Override
    public void save(ScheduleJobEntity scheduleJobEntity) {
        scheduleJobEntity.setCreateTime(new Date());
        scheduleJobEntity.setStatus(Constant.ScheduleStatus.NORMAL.getValue());
        scheduleJobDao.save(scheduleJobEntity);

        ScheduleUtils.createScheduleJob(scheduler, scheduleJobEntity);
    }

    @Override
    public void update(ScheduleJobEntity scheduleJobEntity) {
        ScheduleUtils.updateScheduleJob(scheduler, scheduleJobEntity);

        scheduleJobDao.update(scheduleJobEntity);
    }

    @Override
    public int updateBatch(Long[] jobIds, int status) {
        Map<String, Object> map = new HashMap<>();
        map.put("list", jobIds);
        map.put("status", status);
        return scheduleJobDao.updateBatch(map);
    }

    @Override
    public void deleteBatch(Long[] jobIds) {
        for (Long jobId:
             jobIds) {
            ScheduleUtils.deleteScheduleJob(scheduler,jobId);
        }
        scheduleJobDao.deleteBatch(jobIds);
    }

    @Override
    public void run(Long[] jobIds) {
        for (Long
             jobId:
             jobIds) {
        ScheduleUtils.run(scheduler,queryObject(jobId));
        }
    }

    @Override
    public void pause(Long[] jobIds) {
        for (Long
                jobId:
                jobIds) {
            ScheduleUtils.pauseJob(scheduler,jobId);
        }
        updateBatch(jobIds, Constant.ScheduleStatus.PAUSE.getValue());
    }

    @Override
    public void resume(Long[] jobIds) {
        for (Long
                jobId:
                jobIds) {
            ScheduleUtils.resumeJob(scheduler,jobId);
        }
        updateBatch(jobIds, Constant.ScheduleStatus.NORMAL.getValue());
    }
}
