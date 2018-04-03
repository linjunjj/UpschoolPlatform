package com.linjun.service;

import com.linjun.entity.IdleRalateEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/24.
 * @desc
 **/
@Service
public interface IdleRalateService {
    IdleRalateEntity queryObject(Long id);
    List<IdleRalateEntity> queryList(Map<String, Object> map);
    int queryTotal(Map<String, Object> map);
    void save(IdleRalateEntity idleRalateEntity);
    void update(IdleRalateEntity idleRalateEntity);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
