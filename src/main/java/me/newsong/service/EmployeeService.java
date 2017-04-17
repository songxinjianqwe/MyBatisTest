package me.newsong.service;

import me.newsong.domain.common.PageBean;
import me.newsong.domain.entity.EmployeeDO;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDO> findAllEmployees();
    EmployeeDO findById(Integer id);
    PageBean<EmployeeDO> findEmployees(int currPage, int pageSize); 
    void removeEmployee(Integer id);
    void updateEmployee(EmployeeDO employeeDO);
    void addEmployee(EmployeeDO employeeDO);
}
