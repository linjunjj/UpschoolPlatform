package com.linjun.service.impl;

import com.linjun.dao.ApiUserLevelMapper;
import com.linjun.entity.UserLevelVo;
import com.linjun.service.ApiUserLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/
@Service("apiUserLevelService")
public class ApiUserLevelServiceImpl implements ApiUserLevelService {
    @Autowired
    private ApiUserLevelMapper apiUserLevelMapper;
    @Override
    public UserLevelVo queryObject(Long id) {
        return apiUserLevelMapper.queryObject(id);
    }

    @Override
    public List<UserLevelVo> queryList(Map<String, Object> map) {
        return apiUserLevelMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiUserLevelMapper.queryTotal(map);
    }

    @Override
    public void save(UserLevelVo userLevelVo) {
 apiUserLevelMapper.save(userLevelVo);
    }

    @Override
    public void update(UserLevelVo userLevelVo) {
apiUserLevelMapper.update(userLevelVo);
    }

    @Override
    public void delete(Long id) {
apiUserLevelMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
apiUserLevelMapper.deleteBatch(ids);
    }
}
