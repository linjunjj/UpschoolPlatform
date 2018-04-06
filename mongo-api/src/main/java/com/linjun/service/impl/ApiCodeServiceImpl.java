package com.linjun.service.impl;

import com.linjun.dao.ApiCodeMapper;
import com.linjun.entity.CodeEntity;
import com.linjun.service.ApiCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/23.
 * @desc
 **/
@Service("apiCodeService")
public class ApiCodeServiceImpl implements ApiCodeService{
    @Autowired
    private ApiCodeMapper apiCodeMapper;
    @Override
    public CodeEntity queryObject(Long id) {
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
    public void delete(Long id) {
        apiCodeMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
       apiCodeMapper.deleteBatch(ids);
    }
}
