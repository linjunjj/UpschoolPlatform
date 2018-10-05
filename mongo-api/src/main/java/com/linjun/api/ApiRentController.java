package com.linjun.api;

import com.linjun.util.ApiBaseAction;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 林俊
 * @create 2018/10/5.
 * @desc
 **/
@Api(value = "租房市场")
@RestController
@RequestMapping("/api/rent/")
public class ApiRentController  extends ApiBaseAction {

}
