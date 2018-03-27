package com.linjun.service;

import com.linjun.entity.IdleImagesEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/24.
 * @desc
 **/
@Service
public interface ApiIdleImageService {
    IdleImagesEntity queryObject(Long id);
    List<IdleImagesEntity> queryList(Map<String ,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(IdleImagesEntity idleImagesEntity);
    void update(IdleImagesEntity idleImagesEntity);
    void delete(Long id);
    void deleteBatch(Long[] ids);
}
