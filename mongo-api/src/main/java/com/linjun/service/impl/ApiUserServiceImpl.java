package com.linjun.service.impl;

import com.linjun.dao.ApiUserLevelMapper;
import com.linjun.dao.ApiUserMapper;
import com.linjun.entity.SmsLogVo;
import com.linjun.entity.UserVo;
import com.linjun.entity.UserLevelEntity;
import com.linjun.service.ApiUserService;
import com.linjun.utils.HttpContextUtils;
import com.linjun.utils.IPUtils;
import com.linjun.utils.RRException;
import com.linjun.validator.Assert;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/
@Service("apiUserService")
public class ApiUserServiceImpl implements ApiUserService {
    @Autowired
    private ApiUserMapper apiUserMapper;
    @Autowired
    private ApiUserLevelMapper apiUserLevelMapper;
    @Override
    public UserVo queryObject(Long id) {
        return apiUserMapper.queryObject(id);
    }

    @Override
    public List<UserVo> queryList(Map<String, Object> map) {
        return apiUserMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiUserMapper.queryTotal(map);
    }

    @Override
    public void save(UserVo UserVo) {
apiUserMapper.save(UserVo);
    }

    @Override
    public void save(String mobile, String password) {
        UserVo UserVo=new UserVo();
        UserVo.setMobile(mobile);
        UserVo.setAvatar("http://os3kbkwao.bkt.clouddn.com/timg.jpeg");
        UserVo.setPassword(DigestUtils.sha256Hex(password));
        UserVo.setRegister_time(new Date());
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        UserVo.setRegister_ip(IPUtils.getIpAddr(request));
        apiUserMapper.save(UserVo);
    }

    @Override
    public void update(UserVo UserVo) {
apiUserMapper.update(UserVo);
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
    public UserVo queryByMobile(String mobile) {
        return apiUserMapper.queryByMobile(mobile);
    }

    @Override
    public Long login(String mobile, String password) {
        UserVo UserVo=queryByMobile(mobile);
        Assert.isNull(UserVo,"手机号码或密码为空");
        if (!UserVo.getPassword().equals(DigestUtils.sha1Hex(password))){
            throw new RRException("手机或者密码错误");
        }
              HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
          UserVo UserVo1=new UserVo();
              UserVo1.setUserId(UserVo.getUserId());
              UserVo1.setLast_login_time(new Date());
              UserVo1.setLast_login_ip(IPUtils.getIpAddr(request));
                apiUserMapper.update(UserVo1);
        return UserVo.getUserId();
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
    public String getUserLevel(UserVo loginUser) {
        String result="测试用户";
        UserLevelEntity userLevelEntity=apiUserLevelMapper.queryObject(loginUser.getUser_level_id());
        if (userLevelEntity!=null){
            result=userLevelEntity.getName();
        }

        return result;
    }
}
