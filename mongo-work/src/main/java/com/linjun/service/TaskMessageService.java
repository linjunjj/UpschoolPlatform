package com.linjun.service;

import com.linjun.entity.TaskMessageEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/
@Service
public interface TaskMessageService {
    TaskMessageEntity queryObject(Long id);
    List<TaskMessageEntity> queryList(Map<String, Object> map);
    int queryTotal(Map<String, Object> map);
    void save(TaskMessageEntity taskMessageEntity);
    void update(TaskMessageEntity taskMessageEntity);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
