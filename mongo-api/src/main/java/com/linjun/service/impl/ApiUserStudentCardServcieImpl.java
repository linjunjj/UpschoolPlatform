package com.linjun.service.impl;

import com.linjun.dao.ApiUserStudentCardMapper;
import com.linjun.entity.UserStudentCardVo;
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
@Service("apiUserStudentCardService")
public class ApiUserStudentCardServcieImpl implements ApiUserStudentCardService {
    @Autowired
    private ApiUserStudentCardMapper apiUserStudentCardMapper;
    @Override
    public UserStudentCardVo queryObject(Long id) {
        return apiUserStudentCardMapper.queryObject(id);
    }

    @Override
    public List<UserStudentCardVo> queryList(Map<String, Object> map) {
        return apiUserStudentCardMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiUserStudentCardMapper.queryTotal(map);
    }

    @Override
    public void save(UserStudentCardVo userStudentCardVo) {
 apiUserStudentCardMapper.save(userStudentCardVo);
    }

    @Override
    public void update(UserStudentCardVo userStudentCardVo) {
apiUserStudentCardMapper.update(userStudentCardVo);
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
