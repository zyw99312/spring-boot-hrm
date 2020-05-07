package cn.springboot.hrm.service.impl;

import cn.springboot.hrm.entity.Position;
import cn.springboot.hrm.mapper.PositionMapper;
import cn.springboot.hrm.service.PositionService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Position)表服务实现类
 *
 * @author zyw
 * @since 2020-03-26 19:18:40
 */
@Service("positionService")
public class PositionServiceImpl implements PositionService {
    @Resource
    private PositionMapper positionMapper;

    @Override
    public int getTotalCount() {
        return this.positionMapper.getTotalCount();
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    @Cacheable(value = {"pos"},key = "#id")
    public Position queryById(Integer id) {
        return this.positionMapper.queryById(id);
    }

    /**
     * 获取职位名称
     * @return 职位
     */
    @Override
    public List<Position> findPositionName() {
        return this.positionMapper.findPositionName();
    }

    /**
     * 获取已有的职位名称
     * @return 职位
     */
    @Override
    public List<Position> findPositionObj() {
        return this.positionMapper.findPositionObj();
    }

    /**
     * 根据所属部门编号获取部门名称
     * @param departmentName 部门名称
     * @return 部门名称
     */
    @Override
    public List<Position> getPositionObjByDepartmentName(String departmentName) {
        return this.positionMapper.getPositionObjByDepartmentName(departmentName);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Position> queryAllByLimit(int offset, int limit) {
        return this.positionMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 用于搜索
     * @param position 实例对象
     * @return 对象
     */
    @Override
    @Cacheable(value = {"pos"},key = "#result.id")
    public List<Position> queryAll(Position position) {
        return this.positionMapper.queryAll(position);
    }

    /**
     * 新增数据
     *
     * @param position 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Position position) {
        return this.positionMapper.insert(position);
    }

    /**
     * 修改数据
     *
     * @param position 实例对象
     * @return 实例对象
     */
    @Override
    @CachePut(value = {"pos"},key = "#result.id")
    public Position update(Position position) {
         this.positionMapper.update(position);
         return this.queryById(position.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    @CacheEvict(value = "pos",key = "#id")
    public int deleteById(Integer id) {
        return this.positionMapper.deleteById(id);
    }
}