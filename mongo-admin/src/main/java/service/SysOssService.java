package service;

import entity.SysOssEntity;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/13.
 * @desc
 **/
public interface SysOssService {
    SysOssEntity queryObject(Long id);
    List<SysOssEntity> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(SysOssEntity sysOssEntity);
    void  update(SysOssEntity sysOssEntity);
    void delete(Long id);
    void deleteBatch(Long[] ids);
}
