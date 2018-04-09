package com.linjun.service;

import com.linjun.entity.TaskVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/

public interface ApiTaskService {
    TaskVo queryObject(Long id);
    List<TaskVo> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(TaskVo taskVo);
    void update(TaskVo taskVo);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
