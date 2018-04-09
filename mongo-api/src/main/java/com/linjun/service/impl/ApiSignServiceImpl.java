package com.linjun.service.impl;

import com.linjun.dao.ApiSignMapper;
import com.linjun.entity.SignVo;
import com.linjun.service.ApiSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/25.
 * @desc
 **/
@Service("apiSignService")
public class ApiSignServiceImpl implements ApiSignService {
    @Autowired
    private ApiSignMapper apiSignMapper;
    @Override
    public SignVo queryObject(Long id) {
        return apiSignMapper.queryObject(id);
    }

    @Override
    public List<SignVo> queryList(Map<String, Object> map) {
        return apiSignMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiSignMapper.queryTotal(map);
    }

    @Override
    public void save(SignVo signVo) {
  apiSignMapper.save(signVo);
    }

    @Override
    public void update(SignVo signVo) {
apiSignMapper.update(signVo);
    }

    @Override
    public void delete(Long id) {
apiSignMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
apiSignMapper.deleteBatch(ids);
    }
}
