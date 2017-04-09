package me.newsong.controller;

import me.newsong.domain.User;
import me.newsong.service.iface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//控制器
@RestController
@RequestMapping("/users")
public class UserController {
	//映射请求
	//视图解析器会做如下解析：
	//prefix+返回值+suffix 这样的方式得到实际的物理视图，然后做转发操作
	@Autowired
    private UserService service;
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public User hello(@PathVariable("id") Integer id){
	    return service.findById(id);
	}
	
}
