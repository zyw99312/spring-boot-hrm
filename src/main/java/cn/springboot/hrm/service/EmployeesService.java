package cn.springboot.hrm.service;

import cn.springboot.hrm.entity.Employees;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Employees)表服务接口
 *
 * @author zyw
 * @since 2020-03-26 19:18:40
 */
public interface EmployeesService {

    /**
     * 获取记录总数
     * @return 记录总数
     */
    int getTotalCount();

    /**
     * 获取员工编号
     * @return 获取员工编号
     */
    List<Employees> findEmployeesNo();

    /**
     * 获取已有的职位信息
     * @return  对象列表
     */
    List<Employees> findEmployeesObj();

    /**
     * 获取员工职位名称
     * @param positionName 职位名称
     * @return 职位
     */
    List<Employees> getEmployeesObjByPositionName(@Param("positionName") String positionName);
    /**
     * 通过ID查询单条员工数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Employees queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param startIndex 查询起始位置
     * @param pageSize 查询条数
     * @return 对象列表
     */
    List<Employees> queryAllByLimit(@Param("startIndex") int startIndex,@Param("pageSize") int pageSize);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param employees 实例对象
     * @return 对象列表
     */
    List<Employees> queryAll(Employees employees);

    /**
     * 新增数据
     *
     * @param employees 实例对象
     * @return 影响行数
     */
    int insert(Employees employees);

    /**
     * 修改数据
     *
     * @param employees 实例对象
     * @return 影响行数
     */
    Employees update(Employees employees);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}