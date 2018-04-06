package com.linjun.service.impl;

import com.linjun.dao.SignMapper;
import com.linjun.entity.SignEntity;
import com.linjun.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/4.
 * @desc
 **/
@Service("signService")
public class SignServiceImpl implements SignService {
    @Autowired
   private SignMapper signMapper;

    @Override
    public SignEntity queryObject(Long id) {
        return  signMapper.queryObject(id);
    }

    @Override
    public List<SignEntity> queryList(Map<String, Object> map) {
        return signMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return signMapper.queryTotal(map);
    }

    @Override
    public void save(SignEntity signEntity) {
   signMapper.save(signEntity);
    }

    @Override
    public void update(SignEntity signEntity) {
   signMapper.update(signEntity);
    }

    @Override
    public void delete(Long id) {
    signMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
  signMapper.deleteBatch(ids);
    }
}
