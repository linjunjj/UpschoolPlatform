package com.linjun.service;

import com.linjun.entity.TokenVo;

import java.util.Map;


public interface TokenService {
    TokenVo queryByUserId(Long userId);
    TokenVo queryByToken(String token);
    void save(TokenVo token);
    Map<String, Object> createToken(long userId);



//    @Autowired
//    private ApiTokenMapper tokenDao;
//
//    private final static int EXPIRE = 3600 * 12;
//
//    public TokenVo queryByUserId(Long userId) {
//        return tokenDao.queryByUserId(userId);
//    }
//
//    public TokenVo queryByToken(String token) {
//        return tokenDao.queryByToken(token);
//    }
//
//    public void save(TokenVo token) {
//        tokenDao.save(token);
//    }
//
//    public void update(TokenVo token) {
//        tokenDao.update(token);
//    }
//
//    public Map<String, Object> createToken(long userId) {
//        //生成一个token
//        String token = CharUtil.getRandomString(32);
//        //当前时间
//        Date now = new Date();
//
//        //过期时间
//        Date expireTime = new Date(now.getTime() + EXPIRE * 1000);
//
//        //判断是否生成过token
//        TokenVo tokenEntity = queryByUserId(userId);
//        if (tokenEntity == null) {
//            tokenEntity = new TokenVo();
//            tokenEntity.setUserId(userId);
//            tokenEntity.setToken(token);
//            tokenEntity.setUpdateTime(now);
//            tokenEntity.setExpireTime(expireTime);
//
//            //保存token
//            save(tokenEntity);
//        } else {
//            tokenEntity.setToken(token);
//            tokenEntity.setUpdateTime(now);
//            tokenEntity.setExpireTime(expireTime);
//
//            //更新token
//            update(tokenEntity);
//        }
//
//        Map<String, Object> map = new HashMap<>();
//        map.put("token", token);
//        map.put("expire", EXPIRE);
//
//        return map;
//    }
}
