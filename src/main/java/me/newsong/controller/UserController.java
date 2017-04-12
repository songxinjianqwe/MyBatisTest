package me.newsong.controller;

import me.newsong.domain.User;
import me.newsong.service.iface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//控制器
@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
    private UserService service;
	
	
	@RequestMapping(value="/{name}",method = RequestMethod.GET)
	public List<User> hello(@PathVariable("name") String name){
	    return service.findByUsername(name);
	}
	
	
}
