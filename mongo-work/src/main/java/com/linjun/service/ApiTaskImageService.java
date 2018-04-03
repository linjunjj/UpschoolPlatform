package com.linjun.service;

import com.linjun.entity.TaskImageEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/
@Service
public interface ApiTaskImageService {
    TaskImageEntity queryObject(Long id);
    List<TaskImageEntity> queryList(Map<String, Object> map);
    int queryTotal(Map<String, Object> map);
    void save(TaskImageEntity taskImageEntity);
    void update(TaskImageEntity taskImageEntity);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
