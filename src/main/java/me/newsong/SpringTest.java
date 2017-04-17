package me.newsong;

import me.newsong.dao.EmployeeDOMapper;
import me.newsong.dao.UserDOMapper;
import me.newsong.domain.common.PageBean;
import me.newsong.domain.entity.EmployeeDO;
import me.newsong.domain.entity.UserDO;
import me.newsong.service.EmployeeService;
import me.newsong.util.BaseSpringTester;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.*;

public class SpringTest extends BaseSpringTester {
    @Autowired
    private EmployeeDOMapper employeeDOMapper;
    @Autowired
    private UserDOMapper userDOMapper;
    @Autowired
    private EmployeeService employeeService;

    @Test
    public void test() {
//        employeeDOMapper.findAllEmployees().forEach(System.out::println);
    }

    @Test
    public void testEmp() {
        EmployeeDO emp = new EmployeeDO(null, "123", "M", "123@163.com");
        employeeDOMapper.insert(emp);
        System.out.println(emp.getId());
    }

    @Test
    public void testTimeDate() {
        UserDO user = new UserDO(null, "sinjinsong", "123", LocalDateTime.now(), LocalDate.of(1996, Month.DECEMBER, 26));
        userDOMapper.insert(user);
    }

    @Test
    public void test2() {
        System.out.println(employeeDOMapper.selectByPrimaryKey(1));
    }

    @Test
    public void testPage() {
        PageBean<EmployeeDO> pageBean = employeeService.findEmployees(1, 5);
    }

    @Test
    public void testCache() {
        Instant before = Instant.now();
        employeeService.findEmployees(1, 5);
        System.out.println(Duration.between(Instant.now(), before));
        before = Instant.now();
        employeeService.findEmployees(1, 5);
        System.out.println(Duration.between(Instant.now(), before));
    }

    @Test
    public void testCache2() throws InterruptedException {
        employeeService.findEmployees(1, 5);
        Thread.sleep(10000);
        employeeService.updateEmployee(new EmployeeDO(2,"123","F","123@163.com"));
    }
    
    

//    @Test
//    public void testSelect() {
//        employeeDOMapper.findById("aa").forEach(System.out::println);
//    }
//
//    @Test
//    public void testAdd() {
//        User user = new User("qqqq", "12123");
//        int i = employeeDOMapper.insert(user);
//        System.out.println(i);
//        System.out.println(user.getId());
//    }
//
//    @Test
//    public void testAddUUID() {
////	    User2 user =  new User2("heheda");
////	    mapper2.insert(user);
////        System.out.println(user);
//    }
//
//    @Test
//    public void testUpdate() {
//        User user = employeeDOMapper.selectByPrimaryKey(3);
//        System.out.println(user);
//        user.setUserName("00000");
//        employeeDOMapper.updateByPrimaryKey(user);
//    }
//
//    @Test
//    public void testDelete() {
//        employeeDOMapper.deleteByPrimaryKey(1);
//    }
//
//    @Test
//    public void testRedis() throws InterruptedException {
//        redisCacheManager.putWithExpireTime("123", new User("111", "222"),20);
//        User user = redisCacheManager.get("123", User.class);
//        System.out.println(user);
//        Thread.sleep(20*1000);
//        user = redisCacheManager.get("123", User.class);
//        System.out.println(user);
//        
//    }
//
//    @Test
//    public void testRedisClear() {
//        redisCacheManager.clear();
//    }
//    
//    @Test
//    public void testRedisPutList(){
//        redisCacheManager.putList("111", Arrays.asList(new User("123","123"),new User("456","456")));    
//        List<User> users = redisCacheManager.getList("111",User.class);
//        users.forEach(System.out::println);
//    }
}
