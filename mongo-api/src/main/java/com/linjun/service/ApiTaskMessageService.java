package com.linjun.service;

import com.linjun.entity.TaskMessageVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/

public interface ApiTaskMessageService {
    TaskMessageVo queryObject(Long id);
    List<TaskMessageVo> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(TaskMessageVo taskMessageVo);
    void update(TaskMessageVo taskMessageVo);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
