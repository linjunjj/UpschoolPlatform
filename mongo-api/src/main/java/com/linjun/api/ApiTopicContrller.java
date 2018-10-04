package com.linjun.api;

import com.linjun.annotation.IgnoreAuth;
import com.linjun.annotation.LoginUser;
import com.linjun.entity.TopicVo;
import com.linjun.service.ApiTokenService;
import com.linjun.service.ApiTopicService;
import com.linjun.util.ApiBaseAction;
import com.linjun.utils.JsonResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/10/4.
 * @desc
 **/
@Api(value = "话题接口")
@RestController
@RequestMapping("/api/topic/")
public class ApiTopicContrller extends ApiBaseAction {
    @Autowired
    private ApiTopicService apiTopicService;
    @IgnoreAuth
    @RequestMapping("index")
    public JsonResult index(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size){
        Map params=new HashMap();
        params.put("page",page);
        params.put("limit",size);
        List<TopicVo> lists=apiTopicService.queryList(params);
        return JsonResult.ok(lists);
    }





}
