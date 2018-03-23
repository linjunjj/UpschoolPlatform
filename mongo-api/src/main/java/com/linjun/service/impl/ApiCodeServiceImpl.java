package com.linjun.service.impl;

import com.linjun.dao.ApiCodeMapper;
import com.linjun.entity.CodeEntity;
import com.linjun.service.ApiCodeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/23.
 * @desc
 **/
public class ApiCodeServiceImpl implements ApiCodeService{
    @Autowired
    private ApiCodeMapper apiCodeMapper;
    @Override
    public CodeEntity queryObject(Integer id) {
        return apiCodeMapper.queryObject(id);
    }

    @Override
    public List<CodeEntity> queryList(Map<String, Object> map) {
        return apiCodeMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiCodeMapper.queryTotal(map);
    }

    @Override
    public void save(CodeEntity codeEntity) {
           apiCodeMapper.save(codeEntity);
    }

    @Override
    public void update(CodeEntity codeEntity) {
        apiCodeMapper.update(codeEntity);
    }

    @Override
    public void delete(Integer id) {
        apiCodeMapper.delete(id);
    }

    @Override
    public void deleteBatch(Integer[] ids) {
       apiCodeMapper.deleteBatch(ids);
    }
}
