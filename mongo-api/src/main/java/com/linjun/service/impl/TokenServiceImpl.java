package com.linjun.service.impl;

import com.linjun.dao.ApiTokenMapper;
import com.linjun.entity.TokenVo;
import com.linjun.service.TokenService;
import com.linjun.utils.CharUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/8.
 * @desc
 **/
@Service("tokenService")
public class TokenServiceImpl implements TokenService {
        @Autowired
    private ApiTokenMapper tokenDao;

    private final static int EXPIRE = 3600 * 12;

    public TokenVo queryByUserId(Long userId) {
        return tokenDao.queryByUserId(userId);
    }

    public TokenVo queryByToken(String token) {
        return tokenDao.queryByToken(token);
    }

    public void save(TokenVo token) {
        tokenDao.save(token);
    }

    public void update(TokenVo token) {
        tokenDao.update(token);
    }

    public Map<String, Object> createToken(long userId) {
        //生成一个token
        String token = CharUtil.getRandomString(32);
        //当前时间
        Date now = new Date();

        //过期时间
        Date expireTime = new Date(now.getTime() + EXPIRE * 1000);

        //判断是否生成过token
        TokenVo tokenVo = queryByUserId(userId);
        if (tokenVo == null) {
            tokenVo = new TokenVo();
            tokenVo.setUserId(userId);
            tokenVo.setToken(token);
            tokenVo.setUpdateTime(now);
            tokenVo.setExpireTime(expireTime);

            //保存token
            save(tokenVo);
        } else {
            tokenVo.setToken(token);
            tokenVo.setUpdateTime(now);
            tokenVo.setExpireTime(expireTime);

            //更新token
            update(tokenVo);
        }

        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        map.put("expire", EXPIRE);

        return map;
    }
}
