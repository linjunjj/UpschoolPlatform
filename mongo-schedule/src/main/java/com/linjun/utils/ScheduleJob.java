package com.linjun.utils;

import com.linjun.entity.ScheduleJobEntity;
import com.linjun.service.ScheduleJobLogService;
import com.linjun.service.SysConfigService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * @author 林俊
 * @create 2018/3/10.
 * @desc
 **/
public class ScheduleJob extends QuartzJobBean {
    private Logger logger= LoggerFactory.getLogger(getClass());
    private ExecutorService service= Executors.newSingleThreadExecutor();

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        ScheduleJobEntity scheduleJobEntity=(ScheduleJobEntity) jobExecutionContext.getMergedJobDataMap().get(ScheduleJobEntity.JOB_PARAM_KEY);
        ScheduleJobLogService scheduleJobLogService= (ScheduleJobLogService) SpringContextUtils.getBean("scheduleJobLogService");
        ScheduleJobEntity log=new ScheduleJobEntity();
        log.setJobId(scheduleJobEntity.getJobId());
        log.setBeanName(scheduleJobEntity.getBeanName());
        log.setMethodName(scheduleJobEntity.getMethodName());
        log.setParams(scheduleJobEntity.getParams());
        log.setCreateTime(new Date());
        long startTime= System.currentTimeMillis();
        logger.info("任务装备执行中，任务ID"+scheduleJobEntity.getJobId());
        Schedule
    }
}
