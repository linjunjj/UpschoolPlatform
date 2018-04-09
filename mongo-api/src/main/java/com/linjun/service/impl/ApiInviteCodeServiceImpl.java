package com.linjun.service.impl;

import com.linjun.dao.ApiInviteCodeMapper;
import com.linjun.entity.InviteCodeVo;
import com.linjun.service.ApiInviteCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/24.
 * @desc
 **/
@Service("apiInviteCodeService")
public class ApiInviteCodeServiceImpl implements ApiInviteCodeService {
    @Autowired
    private ApiInviteCodeMapper apiInviteCodeMapper;
    @Override
    public InviteCodeVo queryObject(Long id) {
        return apiInviteCodeMapper.queryObject(id);
    }

    @Override
    public List<InviteCodeVo> queryList(Map<String, Object> map) {
        return apiInviteCodeMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiInviteCodeMapper.queryTotal(map);
    }

    @Override
    public void save(InviteCodeVo inviteCodeVo) {
           apiInviteCodeMapper.save(inviteCodeVo);
    }

    @Override
    public void update(InviteCodeVo inviteCodeVo) {
     apiInviteCodeMapper.update(inviteCodeVo);
    }

    @Override
    public void delete(Long id) {
      apiInviteCodeMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
         apiInviteCodeMapper.deleteBatch(ids);
    }
}
