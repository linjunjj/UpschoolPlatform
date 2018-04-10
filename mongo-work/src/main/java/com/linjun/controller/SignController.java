package com.linjun.controller;

import com.linjun.service.SignDetailService;
import com.linjun.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.PrivateKey;

/**
 * @author 林俊
 * @create 2018/4/10.
 * @desc
 **/
@RestController
@RequestMapping("sign")
public class SignController {
    @Autowired
    private SignService signService;
    @Autowired
    private SignDetailService signDetailService;


}
