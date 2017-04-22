package me.newsong.dao;

import me.newsong.domain.entity.EmployeeDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by SinjinSong on 2017/4/18.
 */
public interface EmployeeDODynamicMapper {
    List<EmployeeDO> findByEmp(EmployeeDO emp);
    List<EmployeeDO> findByEmpOneField(EmployeeDO emp);
    List<EmployeeDO> findByEmpTrim(EmployeeDO emp);
    void updateByPrimaryKey(EmployeeDO emp);
    List<EmployeeDO> findByIds(@Param("ids") List<Integer> ids);
    void insertBatch(@Param("emps") List<EmployeeDO> emps);
    List<EmployeeDO> findByLastNameContains(@Param("lastName") String lastName);
}
