package cn.springboot.cache.service.impl;

import cn.springboot.cache.entity.Employee;
import cn.springboot.cache.mapper.EmployeeMapper;
import cn.springboot.cache.service.EmployeeService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Employee)表服务实现类
 *
 * @author zyw
 * @since 2020-03-25 20:55:49
 */
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    private EmployeeMapper employeeMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    @Cacheable(value = {"emp"}/* , keyGenerator = "myGenerator"*/ )
    public Employee queryById(Integer id) {
        System.out.println("查询得是" + id +"号员工");
        return this.employeeMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Employee> queryAllByLimit(int offset, int limit) {
        return this.employeeMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    @Override
    public Employee insert(Employee employee) {
        this.employeeMapper.insert(employee);
        return employee;
    }

    /**
     * 修改数据
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    @Override
    @CachePut(value="emp",key = "#result.id")
    public Employee update(Employee employee) {
        System.out.println("update emp.."+employee);
        this.employeeMapper.update(employee);
        return this.queryById(employee.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    @CacheEvict(value = "emp",key = "#id")
    public boolean deleteById(Integer id) {
        System.out.println("Delete:"+id);
        return this.employeeMapper.deleteById(id) > 0;
    }
}