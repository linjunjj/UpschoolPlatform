package com.linjun.service;

import com.linjun.entity.InviteRecordEntity;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/11.
 * @desc
 **/
public interface InviteRecordService {
    InviteRecordEntity queryObject(Long id);
    List<InviteRecordEntity> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(InviteRecordEntity inviteRecordVo);
    void update(InviteRecordEntity inviteRecordVo);
    void delete(Long id);
    void deleteBatch(Long[] ids);
}
