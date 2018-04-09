package com.linjun.service.impl;

import com.linjun.dao.ApiSignDetailMapper;
import com.linjun.entity.SignDetailVo;
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
    public SignDetailVo queryObject(Long id) {
        return apiSignDetailMapper.queryObject(id);
    }

    @Override
    public List<SignDetailVo> queryList(Map<String, Object> map) {
        return apiSignDetailMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiSignDetailMapper.queryTotal(map);
    }

    @Override
    public void save(SignDetailVo signDetailVo) {
     apiSignDetailMapper.save(signDetailVo);
    }

    @Override
    public void update(SignDetailVo signDetailVo) {
  apiSignDetailMapper.update(signDetailVo);
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
