package cn.springboot.cache.controller;

import cn.springboot.cache.entity.Department;
import cn.springboot.cache.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Department)表控制层
 *
 * @author zyw
 * @since 2020-03-25 20:59:55
 */
@RestController
@RequestMapping("department")
public class DepartmentController {
    /**
     * 服务对象
     */
    @Autowired
    private DepartmentService departmentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/dept/{id}")
    public Department selectOne(@PathVariable("id") Integer id) {
        return this.departmentService.queryById(id);
    }

}