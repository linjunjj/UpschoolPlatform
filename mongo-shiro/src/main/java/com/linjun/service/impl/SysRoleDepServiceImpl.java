package com.linjun.service.impl;

import com.linjun.dao.SysRoleDeptDao;
import com.linjun.service.SysRoleDepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/11.
 * @desc
 **/
@Service("sysRoleDepService")
public class SysRoleDepServiceImpl implements SysRoleDepService {
    @Autowired
    private SysRoleDeptDao sysRoleDeptDao;
    @Override
    public void saveOrUpdate(Long roleId, List<Long> deptIdList) {
        sysRoleDeptDao.delete(roleId);
        if (deptIdList.size()==0){
            return;
        }
        Map<String,Object> map=new HashMap<>();
        map.put("roleId",roleId);
        map.put("deptIdList",deptIdList);
        sysRoleDeptDao.save(map);
    }

    @Override
    public List<Long> queryDeptIdList(Long roleId) {

        return sysRoleDeptDao.queryDeptIdList(roleId);
    }

    @Override
    public List<Long> queryDeptIdListByUserId(Long userId) {
        return sysRoleDeptDao.queryDeptIdListByUserId(userId);
    }
}
