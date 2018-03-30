package com.linjun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test")
public class TestController {
    @RequestMapping("/toTest")
    public String tojsp() {
        return "test";
    }
}
