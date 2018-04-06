package com.linjun.service;

import com.linjun.entity.SkillEvaluateEntity;
import com.sun.corba.se.spi.presentation.rmi.IDLNameTranslator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/25.
 * @desc
 **/

public interface ApiSkillEvaluateService {
    SkillEvaluateEntity queryObject(Long id);
    List<SkillEvaluateEntity> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(SkillEvaluateEntity skillEvaluateEntity);
    void update(SkillEvaluateEntity skillEvaluateEntity);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
