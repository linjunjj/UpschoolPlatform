package com.linjun.service;

import com.linjun.entity.InviteRecordVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/11.
 * @desc
 **/
public interface ApiInviteReportService {
    InviteRecordVo queryObject(Long id);
    List<InviteRecordVo> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(InviteRecordVo inviteRecordVo);
    void update(InviteRecordVo inviteRecordVo);
    void delete(Long id);
    void deleteBatch(Long[] ids);
}
