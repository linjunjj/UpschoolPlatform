package com.linjun.dao;

import com.linjun.entity.SysDeptEntity;
import com.linjun.entity.UserWindowDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface SysDeptDao extends BaseDao<SysDeptEntity> {

    /**
     * 查询子部门ID列表
     *
     * @param parentId 上级部门ID
     */
    List<Long> queryDetpIdList(Long parentId);


    /**
     * 根据实体条件查询
     * @return
     */
    List<UserWindowDto> queryPageByDto(UserWindowDto userWindowDto);
}
