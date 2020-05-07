package cn.springboot.hrm.service.impl;

import cn.springboot.hrm.entity.Admin;
import cn.springboot.hrm.mapper.AdminMapper;
import cn.springboot.hrm.service.AdminService;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Admin)表服务实现类
 *
 * @author zyw
 * @since 2020-03-26 19:18:37
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;

    /**
     * 获取总记录数
     * @return 记录数
     */
    @Override
    public int getTotalCount() {
        return adminMapper.getTotalCount();
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    @Cacheable(value = {"admin"},key = "#id")
    public Admin queryById(Integer id) {
        return this.adminMapper.queryById(id);
    }

    /**
     * 验证用户是否存在
     * @param admin 实例对象
     * @return 对象
     */
    @Override
    public Admin findAdminByNameAndPwd(Admin admin) {
        return this.adminMapper.findAdminByNameAndPwd(admin);
    }

    /**
     * 查询多条数据
     *
     * @param startIndex 查询起始位置
     * @param pageSize 查询条数
     * @return 对象列表
     */
    @Override
    public List<Admin> queryAllByLimit(int startIndex, int pageSize) {
        return this.adminMapper.queryAllByLimit(startIndex, pageSize);
    }

    /**
     * 用于条件查询
     * @param admin 实例对象
     * @return 用户列表
     */
    @Override
    public List<Admin> queryAll(Admin admin) {
        return adminMapper.queryAll(admin);
    }

    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Admin admin) {
        return this.adminMapper.insert(admin);
    }

    /**
     * 修改数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    @Override
    @CachePut(value="admin",key = "#result.id")
    public Admin update(Admin admin) {
        this.adminMapper.update(admin);
        return this.queryById(admin.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    @CacheEvict(value = "admin",key = "#id")
    public int deleteById(Integer id) {
        return this.adminMapper.deleteById(id);
    }
}