package com.linjun.service.impl;

import com.linjun.dao.InviteRecordMapper;
import com.linjun.entity.InviteRecordEntity;
import com.linjun.service.InviteRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/11.
 * @desc
 **/
@Service("inviteRecordService")
public class InviteRecordServiceImpl implements InviteRecordService {
    @Autowired
    private InviteRecordMapper inviteRecordMapper;
    @Override
    public InviteRecordEntity queryObject(Long id) {
        return inviteRecordMapper.queryObject(id);
    }

    @Override
    public List<InviteRecordEntity> queryList(Map<String, Object> map) {
        return inviteRecordMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return inviteRecordMapper.queryTotal(map);
    }

    @Override
    public void save(InviteRecordEntity inviteRecordEntity) {
     inviteRecordMapper.save(inviteRecordEntity);
    }

    @Override
    public void update(InviteRecordEntity inviteRecordVo) {
    inviteRecordMapper.update(inviteRecordVo);
    }

    @Override
    public void delete(Long id) {
   inviteRecordMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
  inviteRecordMapper.deleteBatch(ids);
    }
}
