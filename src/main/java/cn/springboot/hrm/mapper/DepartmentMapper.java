package cn.springboot.hrm.mapper;

import cn.springboot.hrm.entity.Department;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Department)表数据库访问层
 *
 * @author zyw
 * @since 2020-03-26 19:18:40
 */
public interface DepartmentMapper {

    /**
     * 获取部门记录总数
     * @return int
     */
    int getTotalCount();
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Department queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param startIndex 查询起始位置
     * @param pageSize 查询条数
     * @return 对象列表
     */
    List<Department> queryAllByLimit(@Param("startIndex") int startIndex,@Param("pageSize") int pageSize);

    /**
     * 获取所有部门名称
     * @return 对象列表
     */
    List<Department> getDepartmentName();
    /**
     * 通过实体作为筛选条件查询
     *
     * @param department 实例对象
     * @return 对象列表
     */
    List<Department> queryAll(Department department);

    /**
     * 新增数据
     *
     * @param department 实例对象
     * @return 影响行数
     */
    int insert(Department department);

    /**
     * 修改数据
     *
     * @param department 实例对象
     * @return 影响行数
     */
    int update(Department department);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}