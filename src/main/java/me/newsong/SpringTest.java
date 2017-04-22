package me.newsong;

import com.github.pagehelper.PageInfo;
import me.newsong.dao.DepartmentDOMapper;
import me.newsong.dao.EmployeeDODynamicMapper;
import me.newsong.dao.EmployeeDOMapper;
import me.newsong.dao.UserDOMapper;
import me.newsong.domain.entity.DepartmentDO;
import me.newsong.domain.entity.EmployeeDO;
import me.newsong.domain.entity.UserDO;
import me.newsong.enums.DeptStatus;
import me.newsong.service.EmployeeService;
import me.newsong.util.BaseSpringTester;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.*;
import java.util.Arrays;

public class SpringTest extends BaseSpringTester {
    @Autowired
    private EmployeeDOMapper employeeDOMapper;
    @Autowired
    private UserDOMapper userDOMapper;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentDOMapper departmentDOMapper;
    @Autowired
    private EmployeeDODynamicMapper employeeDODynamicMapper;

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

//    @Test
//    public void testPage() {
//        PageBean<EmployeeDO> pageBean = employeeService.findEmployees(1, 5);
//    }
//
//    @Test
//    public void testCache() {
//        Instant before = Instant.now();
//        employeeService.findEmployees(1, 5);
//        System.out.println(Duration.between(Instant.now(), before));
//        before = Instant.now();
//        employeeService.findEmployees(1, 5);
//        System.out.println(Duration.between(Instant.now(), before));
//    }
//
//    @Test
//    public void testCache2() throws InterruptedException {
//        employeeService.findEmployees(1, 5);
//        Thread.sleep(10000);
//        employeeService.updateEmployee(new EmployeeDO(2, "123", "F", "123@163.com"));
//    }

    @Test
    public void testEmployeeCascade() {
//        System.out.println(employeeDOMapper.findCascadeById(1)); 
        EmployeeDO employeeDO = employeeDOMapper.findCascadeById(1);
        System.out.println(employeeDO.getLastName());
        System.out.println(employeeDO.getDept());
    }

    @Test
    public void testDepartmentCascade() {
        DepartmentDO dept = departmentDOMapper.findDeptByIdWithEmps(1);
        System.out.println(dept.getDeptName());
        System.out.println(dept.getEmps());
    }

    @Test
    public void testDiscriminator() {
        System.out.println(employeeDOMapper.findDiscriminatorById(1));

        System.out.println(employeeDOMapper.findDiscriminatorById(4));
    }

    @Test
    public void testDynamicSQLIf() {
        EmployeeDO emp = new EmployeeDO();
        emp.setLastName("123");
        emp.setGender("F");
        System.out.println(employeeDODynamicMapper.findByEmp(emp));

    }

    @Test
    public void testDynamicSQLChoose() {
        EmployeeDO emp = new EmployeeDO();
        emp.setId(2);
        emp.setLastName("123");
        System.out.println(employeeDODynamicMapper.findByEmpOneField(emp));
    }

    @Test
    public void testDynamicSQLTrim() {
        EmployeeDO emp = new EmployeeDO();
        emp.setId(2);
        emp.setLastName("123");
        System.out.println(employeeDODynamicMapper.findByEmpTrim(emp));
    }
    
    @Test
    public void testDynamicSQLSet(){
        EmployeeDO emp = new EmployeeDO();
        emp.setId(2);
        emp.setLastName("444");
        employeeDODynamicMapper.updateByPrimaryKey(emp);
    }
    
    @Test
    public void testDynamicSQLForeach(){
        employeeDODynamicMapper.findByIds(Arrays.asList(1,2,3)).forEach(System.out::println);    
    }
    
    @Test
    public void testInsertBatch(){
        EmployeeDO emp1 = new EmployeeDO(null,"222","M","222@163.com");
        emp1.setDept(new DepartmentDO(1,null,null));
        EmployeeDO emp2 = new EmployeeDO(null,"333","F","333@163.com");
        emp2.setDept(new DepartmentDO(1,null,null));
        employeeDODynamicMapper.insertBatch(Arrays.asList(emp1,emp2));
    }
    
    @Test
    public void testDynamicSQLBind(){
        employeeDODynamicMapper.findByLastNameContains("a").forEach(System.out::println);    
    }
    
    @Test
    public void testPage2(){
        PageInfo<EmployeeDO> allEmployees = employeeService.findAllEmployees(1, 5);
        System.out.println(allEmployees.getList());
    }
    
    @Test
    public void testEnum(){
        DepartmentDO departmentDO = new DepartmentDO(null,"财务部",DeptStatus.MEETING);
//        departmentDOMapper.insert(departmentDO);
        System.out.println(departmentDOMapper.selectByPrimaryKey(2));
    }

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
