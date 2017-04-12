package me.newsong.service;

import me.newsong.cache.RedisCacheManager;
import me.newsong.dao.UserMapper;
import me.newsong.domain.User;
import me.newsong.util.BaseSpringTester;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

public class SpringTest extends BaseSpringTester {
    @Autowired
    private UserMapper mapper;
    @Autowired
    private RedisCacheManager redisCacheManager;

    @Test
    public void testSelect() {
        mapper.findByUsername("aa").forEach(System.out::println);
    }

    @Test
    public void testAdd() {
        User user = new User("qqqq", "12123");
        int i = mapper.insert(user);
        System.out.println(i);
        System.out.println(user.getId());
    }

    @Test
    public void testAddUUID() {
//	    User2 user =  new User2("heheda");
//	    mapper2.insert(user);
//        System.out.println(user);
    }

    @Test
    public void testUpdate() {
        User user = mapper.selectByPrimaryKey(3);
        System.out.println(user);
        user.setUserName("00000");
        mapper.updateByPrimaryKey(user);
    }

    @Test
    public void testDelete() {
        mapper.deleteByPrimaryKey(1);
    }

    @Test
    public void testRedis() throws InterruptedException {
        redisCacheManager.putWithExpireTime("123", new User("111", "222"),20);
        User user = redisCacheManager.get("123", User.class);
        System.out.println(user);
        Thread.sleep(20*1000);
        user = redisCacheManager.get("123", User.class);
        System.out.println(user);
        
    }

    @Test
    public void testRedisClear() {
        redisCacheManager.clear();
    }
    
    @Test
    public void testRedisPutList(){
        redisCacheManager.putList("111", Arrays.asList(new User("123","123"),new User("456","456")));    
        List<User> users = redisCacheManager.getList("111",User.class);
        users.forEach(System.out::println);
    }
}
