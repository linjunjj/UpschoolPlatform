package com.linjun.service.impl;

import com.linjun.dao.ApiPartTimeMapper;
import com.linjun.entity.PartTimeVo;
import com.linjun.service.ApiPartTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/24.
 * @desc
 **/
@Service("apiPartTimeService")
public class ApiPartTimeServiceImpl implements ApiPartTimeService {
    @Autowired
    private ApiPartTimeMapper apiPartTimeMapper;
    @Override
    public PartTimeVo queryObject(Long id) {
        return apiPartTimeMapper.queryObject(id);
    }

    @Override
    public List<PartTimeVo> queryList(Map<String, Object> map) {
        return apiPartTimeMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiPartTimeMapper.queryTotal(map);
    }

    @Override
    public void save(PartTimeVo partTimeVo) {
    apiPartTimeMapper.save(partTimeVo);
    }

    @Override
    public void update(PartTimeVo partTimeVo) {
   apiPartTimeMapper.update(partTimeVo);
    }

    @Override
    public void delete(Long id) {
    apiPartTimeMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
  apiPartTimeMapper.deleteBatch(ids);
    }
}
