package com.linjun.service;

import com.linjun.entity.DynamicCommentEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/23.
 * @desc
 **/
@Service
public interface DynamicCommentService {
    DynamicCommentEntity queryObject(Long id);
    List<DynamicCommentEntity> queryList(Map<String, Object> map);
    int  queryTotal(Map<String, Object> map);
    void save(DynamicCommentEntity dynamicCommentEntity);
    void update(DynamicCommentEntity dynamicCommentEntity);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
