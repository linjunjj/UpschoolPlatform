package com.linjun.service.impl;

import com.linjun.dao.ApiSignDetailMapper;
import com.linjun.entity.SignDetailEntity;
import com.linjun.service.ApiSignDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/25.
 * @desc
 **/
@Service("apiSignDetailService")
public class ApiSignDetailServiceImpl implements ApiSignDetailService {
    @Autowired
    private ApiSignDetailMapper apiSignDetailMapper;
    @Override
    public SignDetailEntity queryObject(Long id) {
        return apiSignDetailMapper.queryObject(id);
    }

    @Override
    public List<SignDetailEntity> queryList(Map<String, Object> map) {
        return apiSignDetailMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiSignDetailMapper.queryTotal(map);
    }

    @Override
    public void save(SignDetailEntity signDetailEntity) {
     apiSignDetailMapper.save(signDetailEntity);
    }

    @Override
    public void update(SignDetailEntity signDetailEntity) {
  apiSignDetailMapper.update(signDetailEntity);
    }

    @Override
    public void delete(Long id) {
  apiSignDetailMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
  apiSignDetailMapper.deleteBatch(ids);
    }
}
