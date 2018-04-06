package com.linjun.service;

import com.linjun.entity.SmsLogVo;
import com.linjun.entity.UserVo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/

public interface ApiUserService {
    UserVo queryObject(Long id);
    List<UserVo> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(UserVo UserVo);
  void  save(String mobile, String password);
    void update(UserVo UserVo);
    void delete(Long id);
    void deleteBatch(Long[] ids);
    UserVo queryByMobile(String mobile);
    Long login(String mobile, String password);
    SmsLogVo querySmsCodeByUserId(Long user_id);
    int saveSmsCodeLog(SmsLogVo smsLogVo);
    String getUserLevel(UserVo loginUser);
}
