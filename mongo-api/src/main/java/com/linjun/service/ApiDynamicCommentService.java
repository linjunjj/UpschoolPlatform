package com.linjun.service;

import com.linjun.entity.DynamicCommentVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/23.
 * @desc
 **/

public interface ApiDynamicCommentService {
    DynamicCommentVo queryObject(Long id);
    List<DynamicCommentVo> queryList(Map<String ,Object>map);
    int  queryTotal(Map<String,Object> map);
    void save(DynamicCommentVo dynamicCommentVo);
    void update(DynamicCommentVo dynamicCommentVo);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
