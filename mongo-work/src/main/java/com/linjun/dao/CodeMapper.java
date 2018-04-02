package com.linjun.dao;

import com.linjun.entity.CodeEntity;
import org.apache.ibatis.annotations.Param;

/**
 * @author 林俊
 * @create 2018/3/14.
 * @desc
 **/
public interface CodeMapper extends  BaseDao<CodeEntity> {
    CodeEntity queryByMail(@Param("email") String email);
    CodeEntity queryByMobile(@Param("mobile") String mobile) ;
}
