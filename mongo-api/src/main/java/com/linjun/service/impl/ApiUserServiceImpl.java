package com.linjun.service.impl;

import com.linjun.dao.ApiUserLevelMapper;
import com.linjun.dao.ApiUserMapper;
import com.linjun.entity.SmsLogVo;
import com.linjun.entity.UserEntity;
import com.linjun.entity.UserLevelEntity;
import com.linjun.service.ApiUserService;
import com.linjun.utils.RRException;
import com.linjun.validator.Assert;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/
public class ApiUserServiceImpl implements ApiUserService {
    @Autowired
    private ApiUserMapper apiUserMapper;
    @Autowired
    private ApiUserLevelMapper apiUserLevelMapper;
    @Override
    public UserEntity queryObject(Long id) {
        return apiUserMapper.queryObject(id);
    }

    @Override
    public List<UserEntity> queryList(Map<String, Object> map) {
        return apiUserMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiUserMapper.queryTotal(map);
    }

    @Override
    public void save(UserEntity userEntity) {
apiUserMapper.save(userEntity);
    }

    @Override
    public void save(String mobile, String password) {
        UserEntity userEntity=new UserEntity();
        userEntity.setMobile(mobile);
        userEntity.setPassword(DigestUtils.sha256Hex(password));
        userEntity.setRegister_time(new Date());
        apiUserMapper.save(userEntity);
    }

    @Override
    public void update(UserEntity userEntity) {
apiUserMapper.update(userEntity);
    }

    @Override
    public void delete(Long id) {
apiUserMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
apiUserMapper.deleteBatch(ids);
    }

    @Override
    public UserEntity queryByMobile(String mobile) {
        return apiUserMapper.queryByMobile(mobile);
    }

    @Override
    public Long login(String mobile, String password) {
        UserEntity userEntity=queryByMobile(mobile);
        Assert.isNull(userEntity,"手机号码或密码为空");
        if (!userEntity.getPassword().equals(DigestUtils.sha1Hex(password))){
            throw new RRException("手机或者密码错误");
        }

        return userEntity.getUserId();
    }

    @Override
    public SmsLogVo querySmsCodeByUserId(Long user_id) {
        return apiUserMapper.querySmsCodeByUserId(user_id);
    }

    @Override
    public int saveSmsCodeLog(SmsLogVo smsLogVo) {
        return apiUserMapper.saveSmsCodeLog(smsLogVo);
    }

    @Override
    public String getUserLevel(UserEntity loginUser) {
        String result="测试用户";
        UserLevelEntity userLevelEntity=apiUserLevelMapper.queryObject(loginUser.getUser_level_id());
        if (userLevelEntity!=null){
            result=userLevelEntity.getName();
        }

        return result;
    }
}
