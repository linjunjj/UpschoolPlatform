package com.linjun.service;

import com.linjun.entity.SkillCommentVo;


import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/25.
 * @desc
 **/

public interface ApiSkillCommentService {
    SkillCommentVo queryObject(Long id);
    List<SkillCommentVo> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
  void save(SkillCommentVo skillCommentVo);
  void update(SkillCommentVo skillCommentVo);
  void delete(Long id);
  void deleteBatch(Long[] ids);

}
