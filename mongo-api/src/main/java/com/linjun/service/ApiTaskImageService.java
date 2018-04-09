package com.linjun.service;

import com.linjun.entity.TaskImageVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/

public interface ApiTaskImageService {
    TaskImageVo queryObject(Long id);
    List<TaskImageVo> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(TaskImageVo taskImageVo);
    void update(TaskImageVo taskImageVo);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
