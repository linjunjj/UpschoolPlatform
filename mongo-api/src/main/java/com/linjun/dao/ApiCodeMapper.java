package com.linjun.dao;

import com.linjun.entity.CodeVo;
import org.apache.ibatis.annotations.Param;

/**
 * @author 林俊
 * @create 2018/3/14.
 * @desc
 **/
public interface ApiCodeMapper extends  BaseDao<CodeVo> {
    CodeVo queryByMail(@Param("email")String email);
    CodeVo queryByMobile(@Param("mobile")String mobile) ;
}
