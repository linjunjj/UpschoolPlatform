package com.linjun.api;

import com.linjun.annotation.IgnoreAuth;
import com.linjun.annotation.LoginUser;
import com.linjun.entity.UserVo;
import com.linjun.service.ApiUserService;
import com.linjun.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * API测试接口
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-03-23 15:47
 */
@RestController
@RequestMapping("/api/test")
public class ApiTestController {

    @Autowired
    private ApiUserService userService;

    /**
     * 获取用户信息
     */
    @GetMapping("userInfo")
    public JsonResult userInfo(@LoginUser UserVo user) {
        return JsonResult.ok().put("user", user);
    }

    /**
     * 忽略Token验证测试
     */
    @IgnoreAuth
    @GetMapping("notToken")
    public JsonResult notToken() {
        return JsonResult.ok().put("msg", "无需token也能访问。。。");
    }

    /**
     * 根据手机号查询用户信息接口测试方法
     *
     * @param mobile
     * @return
     */
    @IgnoreAuth
    @GetMapping("userListByMobile")
    public JsonResult userList(String mobile) {
        UserVo userEntity = userService.queryByMobile(mobile);
        return JsonResult.ok().put("dto", userEntity);
    }
}
