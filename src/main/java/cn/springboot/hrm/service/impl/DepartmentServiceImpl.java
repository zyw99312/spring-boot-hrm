package cn.springboot.hrm.service.impl;

import cn.springboot.hrm.entity.Department;
import cn.springboot.hrm.mapper.DepartmentMapper;
import cn.springboot.hrm.service.DepartmentService;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Department)表服务实现类
 *
 * @author zyw
 * @since 2020-03-26 19:18:40
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentMapper departmentMapper;

    /**
     * 获取记录总数
     * @return 记录数
     */
    @Override
    public int getTotalCount() {
        return this.departmentMapper.getTotalCount();
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    @Cacheable(value = {"dept"},key = "#id")
    public Department queryById(Integer id) {
        return this.departmentMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param startIndex 查询起始位置
     * @param pageSize 查询条数
     * @return 对象列表
     */
    @Override
    public List<Department> queryAllByLimit(int startIndex, int pageSize) {
        return this.departmentMapper.queryAllByLimit(startIndex, pageSize);
    }

    /**
     * 获取部门名称
     * @return 对象列表
     */
    @Override
    public List<Department> getDepartmentName() {
        return this.departmentMapper.getDepartmentName();
    }

    @Override
    public List<Department> queryAll(Department department) {
        return this.departmentMapper.queryAll(department);
    }

    /**
     * 新增数据
     *
     * @param department 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Department department) {
        return this.departmentMapper.insert(department);
    }

    /**
     * 修改数据
     *
     * @param department 实例对象
     * @return 实例对象
     */
    @Override
    @CachePut(value = {"dept"},key = "#result.id")
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
    @CacheEvict(value = "dept",key = "#id")
    public int deleteById(Integer id) {
        return this.departmentMapper.deleteById(id);
    }
}