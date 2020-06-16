package com.example.validation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api(value = "Demo控制器", tags = "学习模块")
@RestController
@RequestMapping("/demo/")
public class DemoController {

    @ApiOperation(value = "对你说Hello", notes = "根据传入的用户名，向你说Hello！")
    @ApiImplicitParam(name = "name", value = "用户名", required = true, dataType = "String")
    @GetMapping("/sayHello")
    public String sayHello(@RequestParam(value="name") String name) {
        return "Say hello to " + name + ".";
    }

}