package me.newsong.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import me.newsong.domain.entity.EmployeeDO;

public interface EmployeeService {

    PageInfo<EmployeeDO> findAllEmployees(int pageNum, int pageSize);
    EmployeeDO findById(Integer id);
    void removeEmployee(Integer id);
    void updateEmployee(EmployeeDO employeeDO);
    void addEmployee(EmployeeDO employeeDO);
}
