package com.linjun.service;

import com.linjun.entity.TaskEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/
@Service
public interface TaskService {
    TaskEntity queryObject(Long id);
    List<TaskEntity> queryList(Map<String, Object> map);
    int queryTotal(Map<String, Object> map);
    void save(TaskEntity taskEntity);
    void update(TaskEntity taskEntity);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
