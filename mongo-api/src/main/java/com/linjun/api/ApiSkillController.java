package com.linjun.api;

import com.linjun.annotation.IgnoreAuth;
import com.linjun.entity.AdVo;
import com.linjun.entity.SkillCategoryVo;
import com.linjun.entity.SkillVo;
import com.linjun.service.*;
import com.linjun.util.ApiBaseAction;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/10/5.
 * @desc
 **/
@Api(value = "技能分享")
@RestController
@RequestMapping("/api/skill/")
public class ApiSkillController extends ApiBaseAction {
    @Autowired
    private ApiAdService apiAdService;
    @Autowired
    private ApiSkillService apiSkillService;
    @Autowired
    private ApiSkillCategoryService apiSkillCategoryService;
    @Autowired
    private ApiSkillCommentService apiSkillCommentService;
    @Autowired
    private ApiSkillEvaluateService apiSkillEvaluateService;
    @Autowired
    private  ApiSkillImageService apiSkillImageService;
    /*
     *  技能首页数据
     * */
    @IgnoreAuth
    @RequestMapping("index")
    public  Object index(){
        Map<String, Object> resultObj = new HashMap();
        Map param = new HashMap();
        param.put("ad_position_id", 3);
        List<AdVo> banner=apiAdService.queryList(param);
        resultObj.put("banner",banner);
        param=new HashMap();
        param.put("sidx","sort_order");
        param.put("order","asc");
        List<SkillCategoryVo> idleCategroyVos=apiSkillCategoryService.queryList(param);
        resultObj.put("categroy",idleCategroyVos);
        param=new HashMap();
        param.put("sidx","create_time");
        param.put("order","desc");
        param.put("offset",0);
        param.put("limit",11);
        List<SkillVo> idleVoList=apiSkillService.queryList(param);
        resultObj.put("newSkill",idleVoList);
        return  toResponsSuccess(resultObj);
    }





}
