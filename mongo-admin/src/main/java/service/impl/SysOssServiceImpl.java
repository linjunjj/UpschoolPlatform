package service.impl;

import dao.SysOssDao;
import entity.SysOssEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.SysOssService;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/13.
 * @desc
 **/
@Service("sysOssService")
public class SysOssServiceImpl implements SysOssService {
    @Autowired
    private SysOssDao sysOssDao;

    @Override
    public SysOssEntity queryObject(Long id) {
        return sysOssDao.queryObject(id);
    }

    @Override
    public List<SysOssEntity> queryList(Map<String, Object> map) {
        return sysOssDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return sysOssDao.queryTotal(map);
    }

    @Override
    public void save(SysOssEntity sysOssEntity) {
         sysOssDao.save(sysOssEntity);
    }

    @Override
    public void update(SysOssEntity sysOssEntity) {
        sysOssDao.update(sysOssEntity);
    }

    @Override
    public void delete(Long id) {
   sysOssDao.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
           sysOssDao.deleteBatch(ids);
    }
}
