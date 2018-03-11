package com.linjun.service.impl;

import com.linjun.entity.SysMenuEntity;
import com.linjun.service.SysMenuService;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/11.
 * @desc
 **/
public class SysMenuServiceImpl implements SysMenuService {
    @Override
    public List<SysMenuEntity> queryListParentId(Long parentId, List<Long> menIdList) {
        return null;
    }

    @Override
    public List<SysMenuEntity> queryNotButtonList() {
        return null;
    }

    @Override
    public List<SysMenuEntity> getUserMenuList(Long userId) {
        return null;
    }

    @Override
    public SysMenuEntity queryObject() {
        return null;
    }

    @Override
    public List<SysMenuEntity> queryList(Map<String, Object> map) {
        return null;
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return 0;
    }

    @Override
    public void save(SysMenuEntity menu) {

    }

    @Override
    public void update(SysMenuEntity menu) {

    }

    @Override
    public void deleteBatch(Long[] menuIds) {

    }

    @Override
    public List<SysMenuEntity> queryUserList(Long userId) {
        return null;
    }
}
