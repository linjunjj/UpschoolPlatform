package com.linjun.service.impl;

import com.linjun.dao.ApiCodeMapper;
import com.linjun.entity.CodeVo;
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
    public CodeVo queryObject(Long id) {
        return apiCodeMapper.queryObject(id);
    }

    @Override
    public List<CodeVo> queryList(Map<String, Object> map) {
        return apiCodeMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiCodeMapper.queryTotal(map);
    }

    @Override
    public void save(CodeVo codeVo) {
           apiCodeMapper.save(codeVo);
    }

    @Override
    public void update(CodeVo codeVo) {
        apiCodeMapper.update(codeVo);
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
