package cn.springboot.hrm.service;

import cn.springboot.hrm.entity.Position;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Position)表服务接口
 *
 * @author zyw
 * @since 2020-03-26 19:18:40
 */
public interface PositionService {

    /**
     * 获取记录总数
     * @return 记录总数
     */
    int getTotalCount();
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Position queryById(Integer id);

    /**
     * 获取职位名称
     * @return 对象列表
     */
    List<Position> findPositionName();

    /**
     * 获取与所属部门编号相对应的部门编号
     * @return
     */
    List<Position> findPositionObj();
    /**
     * 根据部门编号获取部门名称
     * @param departmentName 部门名称
     * @return 对象列表
     */
    List<Position> getPositionObjByDepartmentName(@Param("departmentName") String departmentName);
    /**
     * 查询指定行数据
     *
     * @param startIndex 查询起始位置
     * @param pageSize 查询条数
     * @return 对象列表
     */
    List<Position> queryAllByLimit(@Param("startIndex,") int startIndex, @Param("pageSize") int pageSize);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param position 实例对象
     * @return 对象列表
     */
    List<Position> queryAll(Position position);

    /**
     * 新增数据
     *
     * @param position 实例对象
     * @return 影响行数
     */
    int insert(Position position);

    /**
     * 修改数据
     *
     * @param position 实例对象
     * @return 影响行数
     */
    Position update(Position position);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}