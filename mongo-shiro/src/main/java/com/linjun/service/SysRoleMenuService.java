package com.linjun.service;


import java.util.List;

/**
 * @author 林俊
 * @create 2018/3/11.
 * @desc
 **/
public interface SysRoleMenuService {
   void saveOrUpdate(Long roleId, List<Long> menuIdList);
   List<Long> queryMenuIdList(Long roleId);
}
