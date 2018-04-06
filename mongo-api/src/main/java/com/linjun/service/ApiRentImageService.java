package com.linjun.service;

import com.linjun.entity.RentImageEntity;
import org.apache.commons.fileupload.util.LimitedInputStream;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/25.
 * @desc
 **/

public interface ApiRentImageService {
    RentImageEntity queryObject(Long id);
    List<RentImageEntity> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(RentImageEntity rentImageEntity);
    void update(RentImageEntity rentImageEntity);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
