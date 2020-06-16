package com.example.validation.controller;

import javax.validation.Valid;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.validation.entity.User;

@Api(value = "validate校验用户", tags = "学习validate")
@RestController
@RequestMapping("/validation/")
public class UserController {

	@ApiOperation(value = "用户测试", notes = "用户测试")
	@PostMapping("/hello")
	public String sayHello(@Valid @RequestBody User user, BindingResult results) {
		if (results.hasErrors()) {
			return "请求参数校验错误：" + 
		           results.getFieldError().getDefaultMessage();
		}
		return "success";
	}

}
