package com.linjun.service.impl;

import com.linjun.dao.IdleMessageMapper;
import com.linjun.entity.IdleMessageEntity;
import com.linjun.service.IdleMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/5/9.
 * @desc
 **/
@Service("IdleMessagesService")
public class IdleMessgaeServiceImpl implements IdleMessageService {
        @Autowired
        private IdleMessageMapper idleMessageMapper;
        @Override
        public IdleMessageEntity queryObject(Long id) {
            return idleMessageMapper.queryObject(id);
        }
        @Override
        public List<IdleMessageEntity> queryList(Map<String, Object> map) {
            return idleMessageMapper.queryList(map);
        }

        @Override
        public int queryTotal(Map<String, Object> map) {
            return idleMessageMapper.queryTotal(map);
        }

        @Override
        public void save(IdleMessageEntity idleMessageVo) {
            idleMessageMapper.save(idleMessageVo);
        }

        @Override
        public void update(IdleMessageEntity idleMessageVo) {
            idleMessageMapper.update(idleMessageVo);
        }

        @Override
        public void delete(Long id) {
            idleMessageMapper.delete(id);
        }

        @Override
        public void deleteBatch(Long[] ids) {
            idleMessageMapper.deleteBatch(ids);
        }


}
