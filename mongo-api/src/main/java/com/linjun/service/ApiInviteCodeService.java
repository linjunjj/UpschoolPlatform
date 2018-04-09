package com.linjun.service;

import com.linjun.entity.InviteCodeVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/24.
 * @desc
 **/

public interface ApiInviteCodeService {
    InviteCodeVo queryObject(Long id);
    List<InviteCodeVo> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(InviteCodeVo inviteCodeVo);
    void update(InviteCodeVo inviteCodeVo);
    void delete(Long id);
    void deleteBatch(Long[] ids);
}
