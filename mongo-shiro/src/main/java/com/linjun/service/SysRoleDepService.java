package com.linjun.service;

import java.util.List;

/**
 * @author 林俊
 * @create 2018/3/11.
 * @desc
 **/
public interface SysRoleDepService {
    void saveOrUpdate(Long roleId, List<Long> deptIdList);
    List<Long> queryDeptIdList(Long roleId);
    List<Long> queryDeptIdListByUserId(Long userId);
}
