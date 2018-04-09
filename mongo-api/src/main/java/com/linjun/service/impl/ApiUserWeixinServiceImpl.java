package com.linjun.service.impl;

import com.linjun.dao.ApiUserWeixinMapper;
import com.linjun.entity.UserWeixinVo;
import com.linjun.service.ApiUserWeixinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/
@Service("apiUserWeixinService")
public class ApiUserWeixinServiceImpl implements ApiUserWeixinService {

    @Autowired
    private ApiUserWeixinMapper apiUserWeixinMapper;
    @Override
    public UserWeixinVo queryObject(Long id) {
        return apiUserWeixinMapper.queryObject(id);
    }

    @Override
    public List<UserWeixinVo> queryList(Map<String, Object> map) {
        return apiUserWeixinMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiUserWeixinMapper.queryTotal(map);
    }

    @Override
    public void save(UserWeixinVo userWeixinVo) {
 apiUserWeixinMapper.save(userWeixinVo);
    }

    @Override
    public void update(UserWeixinVo userWeixinVo) {
apiUserWeixinMapper.update(userWeixinVo);
    }

    @Override
    public void delete(Long id) {
apiUserWeixinMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
apiUserWeixinMapper.deleteBatch(ids);
    }
}
