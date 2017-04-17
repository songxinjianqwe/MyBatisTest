package me.newsong.service.impl;

import me.newsong.dao.EmployeeDOMapper;
import me.newsong.domain.common.PageBean;
import me.newsong.domain.entity.EmployeeDO;
import me.newsong.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDOMapper empDao;

    @Override
    @Cacheable("EmployeeDO")
    public List<EmployeeDO> findAllEmployees() {
        return empDao.findAllEmployees();
    }

    @Override
    @Cacheable("EmployeeDO")
    public EmployeeDO findById(Integer id) {
        return empDao.selectByPrimaryKey(id);
    }

    /**
     * @Cacheable可以标记在一个方法上，也可以标记在一个类上。 
     * 当标记在一个方法上时表示该方法是支持缓存的，当标记在一个类上时则表示该类所有的方法都是支持缓存的。
     * 对于一个支持缓存的方法，Spring会在其被调用后将其返回值缓存起来，
     * 以保证下次利用同样的参数来执行该方法时可以直接从缓存中获取结果，而不需要再次执行该方法。
     * Spring在缓存方法的返回值时是以键值对进行缓存的，值就是方法的返回结果，
     * 至于键的话，Spring又支持两种策略，默认策略和自定义策略。
     * 需要注意的是当一个支持缓存的方法在对象内部被调用时是不会触发缓存功能的。
     * @Cacheable可以指定三个属性，value、key和condition。
     * value属性是必须指定的，其表示当前方法的返回值是会被缓存在哪个Cache上的，对应Cache的名称。
     * 其可以是一个Cache也可以是多个Cache，当需要指定多个Cache时其是一个数组。
     * key属性是用来指定Spring缓存方法的返回结果时对应的key的。该属性支持SpringEL表达式。
     * 当我们没有指定该属性时，Spring将使用默认策略生成key。我们这里先来看看自定义策略，至于默认策略会在后文单独介绍。
     * 自定义策略是指我们可以通过Spring的EL表达式来指定我们的key。
     * 这里的EL表达式可以使用方法参数及它们对应的属性。使用方法参数时我们可以直接使用“#参数名”或者“#p参数index”。
     */
    @Override
    @Cacheable("EmployeeDO")
    public PageBean<EmployeeDO> findEmployees(int currPage, int pageSize) {
        PageBean<EmployeeDO> pageBean = new PageBean<>(currPage, empDao.getCount(), pageSize);
        pageBean.setData(empDao.findEmployeesByPage(pageBean));
        return pageBean;
    }

    /**
     * @param id
     * @CacheEvict可以指定的属性有value、key、condition、allEntries和beforeInvocation 
     * 其中value、key和condition的语义与@Cacheable对应的属性类似。
     * 即value表示清除操作是发生在哪些Cache上的（对应Cache的名称）；
     * key表示需要清除的是哪个key，如未指定则会使用默认策略生成的key
     * allEntries是boolean类型，表示是否需要清除缓存中的同一个cache的所有元素。默认为false，表示不需要。
     * 当指定了allEntries为true时，Spring Cache将忽略指定的key。
     * 有的时候我们需要Cache一下清除所有的元素，这比一个一个清除元素更有效率。
     */
    @Override
    @CacheEvict(value = "EmployeeDO",allEntries = true)
    public void removeEmployee(Integer id) {
        empDao.deleteByPrimaryKey(id);
    }

    @Override
    @CacheEvict(value = "EmployeeDO",allEntries = true)
    public void updateEmployee(EmployeeDO employeeDO) {
        empDao.updateByPrimaryKey(employeeDO);
    }

    @Override
    @CacheEvict(value = "EmployeeDO",allEntries = true)
    public void addEmployee(EmployeeDO employeeDO) {
        empDao.insert(employeeDO);
    }


}
