package com.linjun.service.impl;

import com.linjun.dao.ApiSignMapper;
import com.linjun.entity.SignEntity;
import com.linjun.service.ApiSignService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/25.
 * @desc
 **/
public class ApiSignServiceImpl implements ApiSignService {
    @Autowired
    private ApiSignMapper apiSignMapper;
    @Override
    public SignEntity queryObject(Integer id) {
        return apiSignMapper.queryObject(id);
    }

    @Override
    public List<SignEntity> queryList(Map<String, Object> map) {
        return apiSignMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiSignMapper.queryTotal(map);
    }

    @Override
    public void save(SignEntity signEntity) {
  apiSignMapper.save(signEntity);
    }

    @Override
    public void update(SignEntity signEntity) {
apiSignMapper.update(signEntity);
    }

    @Override
    public void delete(Integer id) {
apiSignMapper.delete(id);
    }

    @Override
    public void deleteBatch(Integer[] ids) {
apiSignMapper.deleteBatch(ids);
    }
}
