package com.linjun.service;

import com.linjun.entity.PartTimeApplyVolumVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/24.
 * @desc
 **/
public interface ApiPartTimeApplyVolumService {
    PartTimeApplyVolumVo queryObject(Long id);
    List<PartTimeApplyVolumVo> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(PartTimeApplyVolumVo partTimeApplyVolumVo);
    void update(PartTimeApplyVolumVo partTimeApplyVolumVo);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
