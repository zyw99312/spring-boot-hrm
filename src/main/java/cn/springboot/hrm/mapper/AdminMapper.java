package cn.springboot.hrm.mapper;

import cn.springboot.hrm.entity.Admin;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Admin)表数据库访问层
 *
 * @author zyw
 * @since 2020-03-26 19:18:39
 */
public interface AdminMapper {


    /**
     * 获取用户总记录数
     * @return 总记录数
     */
    int getTotalCount();

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Admin queryById(Integer id);

    /**
     * 验证用户名密码是否正确
     * @param admin 实例对象
     * @return 实例对象
     */
    Admin findAdminByNameAndPwd(Admin admin);

    /**
     * 查询指定行数据
     *
     * @param startIndex 查询起始位置
     * @param pageSize 查询条数
     * @return 对象列表
     */
    List<Admin> queryAllByLimit(@Param("startIndex") int startIndex,@Param("pageSize") int pageSize);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param admin 实例对象
     * @return 对象列表
     */
    List<Admin> queryAll(Admin admin);

    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 影响行数
     */
    int insert(Admin admin);

    /**
     * 修改数据
     *
     * @param admin 实例对象
     * @return 影响行数
     */
    int update(Admin admin);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}