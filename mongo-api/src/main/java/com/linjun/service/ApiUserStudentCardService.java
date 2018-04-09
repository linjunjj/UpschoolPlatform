package com.linjun.service;

import com.linjun.entity.UserStudentCardVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/

public interface ApiUserStudentCardService {
    UserStudentCardVo queryObject(Long id);
    List<UserStudentCardVo> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(UserStudentCardVo userStudentCardVo);
    void update(UserStudentCardVo userStudentCardVo);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
