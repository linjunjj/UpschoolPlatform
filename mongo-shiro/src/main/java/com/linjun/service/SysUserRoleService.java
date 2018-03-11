package com.linjun.service;

import java.util.List;

/**
 * @author 林俊
 * @create 2018/3/11.
 * @desc
 **/
public interface SysUserRoleService {
    void saveOrUpdate(Long userId, List<Long> roleIdList);
    List<Long> queryRoleIdList(Long userId);
    void delete(Long userId);
}
