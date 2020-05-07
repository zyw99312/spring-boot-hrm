package cn.springboot.hrm.controller;

import cn.springboot.hrm.entity.Department;
import cn.springboot.hrm.entity.Page;
import cn.springboot.hrm.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Department)表控制层
 *
 * @author zyw
 * @since 2020-03-26 19:18:40
 */
@Controller
@RequestMapping("Department")
public class DepartmentController {
    /**
     * 服务对象
     */
    @Resource
    private DepartmentService departmentService;

    private Page page = new Page();
    private int pageSize = 5;

    @GetMapping("/toAdd")
    public String toDepartment(){
        return "Department/add_Department";
    }

    /**
     * 返回并携带结果集
     * @param currPageNo 当前页数
     * @param model model
     * @return view
     */
    @GetMapping("/backQueryDepartment")
    public String backQueryPage(@RequestParam(value="currPageNo",required=false) Integer currPageNo,Model model){
        currPageNo = currPageNo==null||currPageNo<=0?1:currPageNo;
        int totalCount = departmentService.getTotalCount();
        page.setPageSize(pageSize);
        page.setTotalCount(totalCount);
        page.setCurrPageNo(currPageNo);
        int startIndex = (currPageNo - 1) * pageSize;
        List<Department> dbListDepartment = departmentService.queryAllByLimit(startIndex, pageSize);
        model.addAttribute("db_list_department", dbListDepartment);
        model.addAttribute("totalPageCount", page.getTotalPageCount());
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("currPageNo", page.getCurrPageNo());
        return "Department/query_Department";
    }

    /**
     * 获取所有部门信息并分页显示
     * @param currPageNo 当前页数
     * @param model model
     * @return view
     */
    @GetMapping("/queryDepartment/{currPageNo}")
    public String queryDepartment(@PathVariable(value="currPageNo") Integer currPageNo,Model model){
        int totalCount = departmentService.getTotalCount();
        currPageNo = currPageNo==null||currPageNo<=0?1:currPageNo;
        page.setPageSize(pageSize);
        page.setTotalCount(totalCount);
        page.setCurrPageNo(currPageNo);
        int startIndex = (currPageNo - 1) * pageSize;
        List<Department> dbListDepartment = departmentService.queryAllByLimit(startIndex, pageSize);
        model.addAttribute("db_list_department", dbListDepartment);
        model.addAttribute("totalPageCount", page.getTotalPageCount());
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("currPageNo", page.getCurrPageNo());
        return "Department/query_Department";
    }

    /**
     * 根据id查询部门并返回修改页面
     * @param id id
     * @param model model
     * @return view
     */
    @GetMapping(value="/queryDepartmentById/{id}")
    public String queryDepartmentById(@PathVariable("id")int id,Model model) {

        Department dbListDepartment =  departmentService.queryById(id);
        if(dbListDepartment != null) {
            model.addAttribute("db_list_department", dbListDepartment);
            return "Department/update_Department";
        }
        return "main";
    }

    /**
     * 新增部门
     * @param department 对象
     * @return view
     */
    @PostMapping(value="/addDepartment")
    public String addDepartment(Department department) {
        departmentService.insert(department);
        return "Department/add_Department";
    }

    /**
     * 修改部门信息
     * @param department 对象
     * @return controller view
     */
    @PutMapping(value="/updateDepartment")
    public String updateDepartment(Department department) {
        departmentService.update(department);
        return "redirect:/Department/backQueryDepartment";
    }

    /**
     * 根据id删除部门信息
     * @param id id
     * @return controller view
     */
    @DeleteMapping("/deleteDepartment/{id}")
    public String deleteDepartment(@PathVariable("id")int id){
        departmentService.deleteById(id);
        return "redirect:/Department/backQueryDepartment";
    }

}