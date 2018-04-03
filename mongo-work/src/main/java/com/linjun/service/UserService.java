package com.linjun.service;

import com.linjun.entity.SmsLogVo;
import com.linjun.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/
@Service
public interface UserService {
    UserEntity queryObject(Long id);
    List<UserEntity> queryList(Map<String, Object> map);
    int queryTotal(Map<String, Object> map);
    void save(UserEntity userEntity);
  void  save(String mobile, String password);
    void update(UserEntity userEntity);
    void delete(Long id);
    void deleteBatch(Long[] ids);
    UserEntity queryByMobile(String mobile);
    Long login(String mobile, String password);
    SmsLogVo querySmsCodeByUserId(Long user_id);
    int saveSmsCodeLog(SmsLogVo smsLogVo);
    String getUserLevel(UserEntity loginUser);
}
