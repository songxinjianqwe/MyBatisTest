package me.newsong.service;

import me.newsong.dao.UserMapper;
import me.newsong.utils.BaseSpringTester;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SpringTest extends BaseSpringTester{
	@Autowired
    private UserMapper mapper;
    @Test
	public void test() {
        System.out.println(mapper.selectByPrimaryKey(1));
	}
	
}
