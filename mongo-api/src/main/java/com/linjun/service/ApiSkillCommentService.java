package com.linjun.service;

import com.linjun.entity.SkillCommentEntity;


import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/25.
 * @desc
 **/

public interface ApiSkillCommentService {
    SkillCommentEntity queryObject(Long id);
    List<SkillCommentEntity> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
  void save(SkillCommentEntity skillCommentEntity);
  void update(SkillCommentEntity skillCommentEntity);
  void delete(Long id);
  void deleteBatch(Long[] ids);

}
