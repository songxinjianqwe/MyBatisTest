package me.newsong.controller;

import me.newsong.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by SinjinSong on 2017/4/14.
 */
@RestController
@RequestMapping("/emps")
public class EmployeeController {
    @Autowired
    private EmployeeService service;
    
    
}
