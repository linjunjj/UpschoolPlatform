package com.linjun.service.impl;

import com.linjun.dao.ApiPartTimeCategoryMapper;
import com.linjun.entity.PartTimeCategoryVo;
import com.linjun.service.ApiPartTimeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/24.
 * @desc
 **/
@Service("apiPartTimeCategoryService")
public class ApiPartTimeCategoryServiceImpl implements ApiPartTimeCategoryService {
    @Autowired
    private ApiPartTimeCategoryMapper apiPartTimeCategoryMapper;
    @Override
    public PartTimeCategoryVo queryObject(Long id) {
        return apiPartTimeCategoryMapper.queryObject(id);
    }

    @Override
    public List<PartTimeCategoryVo> queryList(Map<String, Object> map) {
        return apiPartTimeCategoryMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return  apiPartTimeCategoryMapper.queryTotal(map);
    }

    @Override
    public void save(PartTimeCategoryVo partTimeCategoryVo) {
    apiPartTimeCategoryMapper.save(partTimeCategoryVo);
    }

    @Override
    public void update(PartTimeCategoryVo partTimeCategoryVo) {
apiPartTimeCategoryMapper.update(partTimeCategoryVo);
    }

    @Override
    public void delete(Long id) {
    apiPartTimeCategoryMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
      apiPartTimeCategoryMapper.deleteBatch(ids);
    }
}
