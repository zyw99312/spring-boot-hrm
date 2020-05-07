package cn.springboot.cache.service.impl;

import cn.springboot.cache.entity.Department;
import cn.springboot.cache.mapper.DepartmentMapper;
import cn.springboot.cache.service.DepartmentService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Department)表服务实现类
 *
 * @author zyw
 * @since 2020-03-25 20:55:48
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentMapper departmentMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    @Cacheable(value = "dept")
    public Department queryById(Integer id) {
        System.out.println("查询部门："+id);
        return this.departmentMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Department> queryAllByLimit(int offset, int limit) {
        return this.departmentMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param department 实例对象
     * @return 实例对象
     */
    @Override
    public Department insert(Department department) {
        this.departmentMapper.insert(department);
        return department;
    }

    /**
     * 修改数据
     *
     * @param department 实例对象
     * @return 实例对象
     */
    @Override
    public Department update(Department department) {
        this.departmentMapper.update(department);
        return this.queryById(department.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.departmentMapper.deleteById(id) > 0;
    }
}