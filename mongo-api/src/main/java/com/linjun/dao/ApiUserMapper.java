package com.linjun.dao;

import com.linjun.entity.SmsLogVo;
import com.linjun.entity.UserVo;
import org.apache.ibatis.annotations.Param;

/**
 * @author 林俊
 * @create 2018/3/14.
 * @desc
 **/
public interface ApiUserMapper extends  BaseDao<UserVo> {
    UserVo queryByMobile(@Param("mobile") String mobile);
    UserVo queryByOpenId(@Param("openId") String openId);
    SmsLogVo querySmsCodeByUserId(@Param("user_id") Long user_id);
    int saveSmsCodeLog(SmsLogVo smsLogVo);
}
