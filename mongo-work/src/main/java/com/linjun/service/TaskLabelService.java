package com.linjun.service;

import com.linjun.entity.TaskLabelEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/
@Service
public interface TaskLabelService {
    TaskLabelEntity queryObject(Long id);
    List<TaskLabelEntity> queryList(Map<String, Object> map);
    int queryTotal(Map<String, Object> map);
    void save(TaskLabelEntity taskLabelEntity);
    void update(TaskLabelEntity taskLabelEntity);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
