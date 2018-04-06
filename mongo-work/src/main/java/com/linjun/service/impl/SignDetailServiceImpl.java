package com.linjun.service.impl;

import com.linjun.dao.SignDetailMapper;
import com.linjun.entity.SignDetailEntity;
import com.linjun.service.SignDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/4.
 * @desc
 **/
@Service
public class SignDetailServiceImpl implements SignDetailService {
    @Autowired
    private SignDetailMapper signDetailMapper;
    @Override
    public SignDetailEntity queryObject(Long id) {
        return signDetailMapper.queryObject(id);
    }

    @Override
    public List<SignDetailEntity> queryList(Map<String, Object> map) {
        return signDetailMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return signDetailMapper.queryTotal(map);
    }

    @Override
    public void save(SignDetailEntity signDetailEntity) {
    signDetailMapper.save(signDetailEntity);
    }

    @Override
    public void update(SignDetailEntity signDetailEntity) {
   signDetailMapper.update(signDetailEntity);
    }

    @Override
    public void delete(Long id) {
  signDetailMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
   signDetailMapper.deleteBatch(ids);
    }
}
