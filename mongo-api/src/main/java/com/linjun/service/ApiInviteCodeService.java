package com.linjun.service;

import com.linjun.entity.InviteCodeEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/24.
 * @desc
 **/
@Service
public interface ApiInviteCodeService {
    InviteCodeEntity queryObject(Long id);
    List<InviteCodeEntity> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(InviteCodeEntity inviteCodeEntity);
    void update(InviteCodeEntity inviteCodeEntity);
    void delete(Long id);
    void deleteBatch(Long[] ids);
}
