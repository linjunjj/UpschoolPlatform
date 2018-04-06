package com.linjun.service.impl;

import com.linjun.dao.IdleImagesMapper;
import com.linjun.entity.IdleImagesEntity;
import com.linjun.service.IdleImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/3.
 * @desc
 **/
@Service("idleImageService")
public class IdleImageServiceImpl implements IdleImageService {
    @Autowired
    private IdleImagesMapper idleImagesMapper;
    @Override
    public IdleImagesEntity queryObject(Long id) {
        return idleImagesMapper.queryObject(id);
    }

    @Override
    public List<IdleImagesEntity> queryList(Map<String, Object> map) {
        return idleImagesMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return idleImagesMapper.queryTotal(map);
    }

    @Override
    public void save(IdleImagesEntity idleImagesEntity) {
   idleImagesMapper.save(idleImagesEntity);
    }

    @Override
    public void update(IdleImagesEntity idleImagesEntity) {
   idleImagesMapper.update(idleImagesEntity);
    }

    @Override
    public void delete(Long id) {
  idleImagesMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
  idleImagesMapper.deleteBatch(ids);
    }
}
