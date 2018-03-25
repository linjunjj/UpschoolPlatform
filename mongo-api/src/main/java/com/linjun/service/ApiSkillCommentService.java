package com.linjun.service;

import com.fasterxml.jackson.core.json.async.NonBlockingJsonParser;
import com.linjun.entity.SkillCommentEntity;
import org.springframework.stereotype.Service;
import sun.jvm.hotspot.debugger.MachineDescriptionPPC;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/25.
 * @desc
 **/
@Service
public interface ApiSkillCommentService {
    SkillCommentEntity queryObject(Integer id);
    List<SkillCommentEntity> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
  void save(SkillCommentEntity skillCommentEntity);
  void update(SkillCommentEntity skillCommentEntity);
  void delete(Integer id);
  void deleteBatch(Integer[] ids);

}
