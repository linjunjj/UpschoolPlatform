package com.linjun.service.impl;

import com.linjun.dao.InviteCodeMapper;
import com.linjun.entity.InviteCodeEntity;
import com.linjun.service.InviteCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/3.
 * @desc
 **/
@Service("inviteCodeService")
public class InviteCodeServiceImpl implements InviteCodeService {
    @Autowired
    private InviteCodeMapper inviteCodeMapper;
    @Override
    public InviteCodeEntity queryObject(Long id) {
        return inviteCodeMapper.queryObject(id);
    }

    @Override
    public List<InviteCodeEntity> queryList(Map<String, Object> map) {
        return inviteCodeMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return  inviteCodeMapper.queryTotal(map);
    }

    @Override
    public void save(InviteCodeEntity inviteCodeEntity) {
   inviteCodeMapper.save(inviteCodeEntity);
    }

    @Override
    public void update(InviteCodeEntity inviteCodeEntity) {
  inviteCodeMapper.update(inviteCodeEntity);
    }

    @Override
    public void delete(Long id) {
   inviteCodeMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
   inviteCodeMapper.deleteBatch(ids);
    }
}
