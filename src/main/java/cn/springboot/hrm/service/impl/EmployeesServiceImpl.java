package cn.springboot.hrm.service.impl;

import cn.springboot.hrm.entity.Employees;
import cn.springboot.hrm.mapper.EmployeesMapper;
import cn.springboot.hrm.service.EmployeesService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Employees)表服务实现类
 *
 * @author zyw
 * @since 2020-03-26 19:18:40
 */
@Service("employeesService")
public class EmployeesServiceImpl implements EmployeesService {
    @Resource
    private EmployeesMapper employeesMapper;

    /**
     * 获取记录总数
     * @return 总数
     */
    @Override
    public int getTotalCount() {
        return this.employeesMapper.getTotalCount();
    }

    /**
     * 获取员工编号
     * @return 编号
     */
    @Override
    public List<Employees> findEmployeesNo() {
        return this.employeesMapper.findEmployeesNo();
    }

    @Override
    public List<Employees> findEmployeesObj() {
        return this.employeesMapper.findEmployeesObj();
    }

    @Override
    public List<Employees> getEmployeesObjByPositionName(String positionName) {
        return this.employeesMapper.getEmployeesObjByPositionName(positionName);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    @Cacheable(value = {"emp"},key = "#id")
    public Employees queryById(Integer id) {
        return this.employeesMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param startIndex 查询起始位置
     * @param pageSize 查询条数
     * @return 对象列表
     */
    @Override
    public List<Employees> queryAllByLimit(int startIndex, int pageSize) {
        return this.employeesMapper.queryAllByLimit(startIndex, pageSize);
    }

    /**
     * 用于搜索
     * @param employees 实例对象
     * @return 对象
     */
    @Override
    public List<Employees> queryAll(Employees employees) {
        return this.employeesMapper.queryAll(employees);
    }

    /**
     * 新增数据
     *
     * @param employees 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Employees employees) {
        return this.employeesMapper.insert(employees);
    }

    /**
     * 修改数据
     *
     * @param employees 实例对象
     * @return 实例对象
     */
    @Override
    @CachePut(value = {"emp"},key = "#result.id")
    public Employees update(Employees employees) {
        this.employeesMapper.update(employees);
        return this.queryById(employees.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    @CacheEvict(value = "emp",key = "#id")
    public int deleteById(Integer id) {
        return this.employeesMapper.deleteById(id);
    }
}