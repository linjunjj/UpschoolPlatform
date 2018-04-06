package com.linjun.service.impl;

import com.linjun.dao.ApiUserStudentCardMapper;
import com.linjun.entity.UserStudentCardEntity;
import com.linjun.service.ApiUserStudentCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/
@Service
public class ApiUserStudentCardServcieImpl implements ApiUserStudentCardService {
    @Autowired
    private ApiUserStudentCardMapper apiUserStudentCardMapper;
    @Override
    public UserStudentCardEntity queryObject(Long id) {
        return apiUserStudentCardMapper.queryObject(id);
    }

    @Override
    public List<UserStudentCardEntity> queryList(Map<String, Object> map) {
        return apiUserStudentCardMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiUserStudentCardMapper.queryTotal(map);
    }

    @Override
    public void save(UserStudentCardEntity userStudentCardEntity) {
 apiUserStudentCardMapper.save(userStudentCardEntity);
    }

    @Override
    public void update(UserStudentCardEntity userStudentCardEntity) {
apiUserStudentCardMapper.update(userStudentCardEntity);
    }

    @Override
    public void delete(Long id) {
apiUserStudentCardMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
apiUserStudentCardMapper.deleteBatch(ids);
    }
}
