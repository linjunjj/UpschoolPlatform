package com.linjun.service;


import com.linjun.entity.SysUserEntity;
import com.linjun.entity.UserWindowDto;
import com.linjun.page.Page;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/11.
 * @desc
 **/
public interface SysUserService {
    List<String> queryAllPerms(Long userId);
    List<Long> queryAllMenuId(Long userId);
    SysUserEntity queryByUserName(String username);
    SysUserEntity queryObject(Long userId);
    List<SysUserEntity> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(SysUserEntity user);
    void update(SysUserEntity user);
    void deleteBatch(Long[] userIds);
    int updatePassword(Long userId,String password,String newPassword);
    Page<UserWindowDto> findPage(UserWindowDto userentity,int pageNum);

}
