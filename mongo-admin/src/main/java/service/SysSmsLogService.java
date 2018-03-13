package service;

import entity.SysSmsLogEntity;

import java.util.List;
import java.util.Map;


/**
 * @author 林俊
 * @create 2018/3/13.
 * @desc
 **/
public interface SysSmsLogService {
    SysSmsLogEntity queryObject(String id);
    List<SysSmsLogEntity> queryList(Map<String,Object> map);
    int quertTotral(Map<String,Object> map);
    int save(SysSmsLogEntity sysSmsLogEntity);
    int update(SysSmsLogEntity sysSmsLogEntity);
    int delete(String id);
    int deleteBatch(String[] ids);

    SysSmsLogEntity sendSms(SysSmsLogEntity sysSmsLogEntity);

}
