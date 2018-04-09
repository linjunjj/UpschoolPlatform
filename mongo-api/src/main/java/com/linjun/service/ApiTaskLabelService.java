package com.linjun.service;

import com.linjun.entity.TaskLabelVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/

public interface ApiTaskLabelService {
    TaskLabelVo queryObject(Long id);
    List<TaskLabelVo> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(TaskLabelVo taskLabelVo);
    void update(TaskLabelVo taskLabelVo);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
