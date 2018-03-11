package com.linjun.service;

import com.linjun.entity.SysMenuEntity;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/11.
 * @desc
 **/
public interface SysMenuService {
    List<SysMenuEntity>  queryListParentId(Long parentId,List<Long> menIdList);
    List<SysMenuEntity>   queryNotButtonList();
    List<SysMenuEntity>        getUserMenuList(Long userId);
    SysMenuEntity queryObject(Long menuId);
    List<SysMenuEntity> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(SysMenuEntity menu);
    void update(SysMenuEntity menu);
    void deleteBatch(Long[] menuIds);
    List<SysMenuEntity> queryUserList(Long userId);

}
