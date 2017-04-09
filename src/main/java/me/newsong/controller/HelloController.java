package me.newsong.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//控制器
@RestController 
public class HelloController {
	//映射请求
	//视图解析器会做如下解析：
	//prefix+返回值+suffix 这样的方式得到实际的物理视图，然后做转发操作
	
	@RequestMapping("/helloworld")
	public String hello(){
		System.out.println("hello world");
		return "success";
	}
	
}
