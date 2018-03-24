package com.linjun.service.impl;

import com.linjun.dao.ApiInviteCodeMapper;
import com.linjun.entity.InviteCodeEntity;
import com.linjun.service.ApiInviteCodeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/24.
 * @desc
 **/
public class ApiInviteCodeServiceImpl implements ApiInviteCodeService {
    @Autowired
    private ApiInviteCodeMapper apiInviteCodeMapper;
    @Override
    public InviteCodeEntity queryObject(Integer id) {
        return apiInviteCodeMapper.queryObject(id);
    }

    @Override
    public List<InviteCodeEntity> queryList(Map<String, Object> map) {
        return apiInviteCodeMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiInviteCodeMapper.queryTotal(map);
    }

    @Override
    public void save(InviteCodeEntity inviteCodeEntity) {
           apiInviteCodeMapper.save(inviteCodeEntity);
    }

    @Override
    public void update(InviteCodeEntity inviteCodeEntity) {
     apiInviteCodeMapper.update(inviteCodeEntity);
    }

    @Override
    public void delete(Integer id) {
      apiInviteCodeMapper.delete(id);
    }

    @Override
    public void deleteBatch(Integer[] ids) {
         apiInviteCodeMapper.deleteBatch(ids);
    }
}
