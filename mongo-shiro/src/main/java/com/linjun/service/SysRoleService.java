package com.linjun.service;

import com.linjun.entity.SysRoleEntity;
import com.linjun.entity.UserWindowDto;
import com.linjun.page.Page;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/11.
 * @desc
 **/
public interface SysRoleService {
    SysRoleEntity queryObject(Long roleId);
    List<SysRoleEntity> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(SysRoleEntity role);
    void update(SysRoleEntity role);
    void deleteBatch(Long[] releIds);
    List<Long> queryRoleIdList(Long createUserId);
    Page<UserWindowDto> queryPageByDto(UserWindowDto userWindowDto,int pageNmu);
}
