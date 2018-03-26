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
public interface ApiTaskMessageService {
    TaskMessageEntity queryObject(Integer id);
    List<TaskMessageEntity> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(TaskMessageEntity taskMessageEntity);
    void update(TaskMessageEntity taskMessageEntity);
    void delete(Integer id);
    void deleteBatch(Integer[] ids);

}
