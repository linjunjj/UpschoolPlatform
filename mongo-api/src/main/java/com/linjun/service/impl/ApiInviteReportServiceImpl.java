package com.linjun.service.impl;

import com.linjun.dao.ApiInviteRecordMapper;
import com.linjun.entity.InviteRecordVo;
import com.linjun.service.ApiInviteReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/11.
 * @desc
 **/
@Service("apiInviteReportService")
public class ApiInviteReportServiceImpl implements ApiInviteReportService {
    @Autowired
    private ApiInviteRecordMapper apiInviteRecordMapper;
    @Override
    public InviteRecordVo queryObject(Long id) {
        return apiInviteRecordMapper.queryObject(id);
    }

    @Override
    public List<InviteRecordVo> queryList(Map<String, Object> map) {
        return apiInviteRecordMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiInviteRecordMapper.queryTotal(map);
    }

    @Override
    public void save(InviteRecordVo inviteRecordVo) {
apiInviteRecordMapper.save(inviteRecordVo);
    }

    @Override
    public void update(InviteRecordVo inviteRecordVo) {
   apiInviteRecordMapper.update(inviteRecordVo);
    }

    @Override
    public void delete(Long id) {
  apiInviteRecordMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
   apiInviteRecordMapper.deleteBatch(ids);
    }
}
