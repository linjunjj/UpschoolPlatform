package controller;

import com.linjun.annotation.IgnoreAuth;
import com.linjun.utils.*;
import entity.SysSmsLogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.SysSmsLogService;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/13.
 * @desc
 **/
@RestController
@RequestMapping("api")
public class ApiSmsController {
    @Autowired
    private SysSmsLogService smsLogService;

    /**
     * 发送短信
     * mobile：电话号码字符串，中间用英文逗号间隔
     * content：内容字符串
     * stime：追加发送时间，可为空，为空为及时发送
     */
    @IgnoreAuth
    @RequestMapping("/sendSms")
    public JsonResult sendSms(HttpServletRequest request, @RequestParam Map<String, String> params) {
        SysSmsLogEntity smsLog = new SysSmsLogEntity();
        String validIP = RequestUtil.getIpAddrByRequest(request);
        if (ResourceUtil.getConfigByName("sms.validIp").indexOf(validIP) < 0) {
            throw new RRException("非法IP请求！");
        }
        smsLog.setMobile(params.get("mobile"));
        smsLog.setContent(params.get("content"));
        String stime = params.get("stime");
        if (StringUtils.isNotEmpty(stime)) {
            smsLog.setStime(DateUtils.convertStringToDate(stime));
        }
        SysSmsLogEntity sysSmsLogEntity = smsLogService.sendSms(smsLog);
        return JsonResult.ok().put("result", sysSmsLogEntity);
    }
}
