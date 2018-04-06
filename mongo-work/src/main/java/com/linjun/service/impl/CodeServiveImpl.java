package com.linjun.service.impl;

import com.linjun.dao.CodeMapper;
import com.linjun.entity.CodeEntity;
import com.linjun.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/3.
 * @desc
 **/
@Service
public class CodeServiveImpl implements CodeService {
    @Autowired
    private CodeMapper codeMapper;
    @Override
    public CodeEntity queryObject(Long id) {
        return codeMapper.queryObject(id);
    }

    @Override
    public List<CodeEntity> queryList(Map<String, Object> map) {
        return null;
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return 0;
    }

    @Override
    public void save(CodeEntity codeEntity) {

    }

    @Override
    public void update(CodeEntity codeEntity) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void deleteBatch(Long[] ids) {

    }
}
