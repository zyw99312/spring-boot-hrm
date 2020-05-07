package cn.springboot.cache.controller;

import cn.springboot.cache.entity.Employee;
import cn.springboot.cache.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Employee)表控制层
 *
 * @author zyw
 * @since 2020-03-25 20:59:56
 */
@RestController
@RequestMapping("employee")
public class EmployeeController {
    /**
     * 服务对象
     */
    @Resource
    private EmployeeService employeeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("emp/{id}")
    public Employee selectOne(@PathVariable("id") Integer id) {
        return this.employeeService.queryById(id);
    }

    @GetMapping("/emp")
    public Employee updateEmp(Employee employee){
        return employeeService.update(employee);
    }

    @GetMapping("/delEmp")
    public String deleteEmp(Integer id){
        employeeService.deleteById(id);
        return id+"删除成功！";
    }

}