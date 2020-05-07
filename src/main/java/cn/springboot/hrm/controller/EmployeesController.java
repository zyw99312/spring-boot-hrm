package cn.springboot.hrm.controller;

import cn.springboot.hrm.entity.Employees;
import cn.springboot.hrm.entity.Page;
import cn.springboot.hrm.service.EmployeesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Employees)表控制层
 *
 * @author zyw
 * @since 2020-03-26 19:18:40
 */
@Controller
@RequestMapping("Employees")
public class EmployeesController {
    /**
     * 服务对象
     */
    @Resource
    private EmployeesService employeesService;

    private Page page = new Page();
    private int pageSize = 5;
    /**
     * 跳转到新增页面
     * @param model
     * @return
     */
    @GetMapping("/toAdd")
    public String toEmployees(Model model){
        List<Employees> dbListEmployees = employeesService.findEmployeesObj();
        if(dbListEmployees != null) {
            model.addAttribute("db_list_employees", dbListEmployees);
        }
        return "Employees/add_Employees";
    }

    /**
     * 信息修改万跳转到查询列表页面
     * @param currPageNo
     * @param model
     * @return
     */
    @GetMapping("/backQueryEmployees")
    public String backQueryPage(
            @RequestParam(value="currPageNo",required=false) Integer currPageNo,
            Model model){
        currPageNo = currPageNo==null||currPageNo<=0?1:currPageNo;
        int totalCount = employeesService.getTotalCount();
        page.setPageSize(pageSize);
        page.setTotalCount(totalCount);
        page.setCurrPageNo(currPageNo);
        int startIndex = (currPageNo - 1) * pageSize;
        List<Employees> dbListEmployees = employeesService.queryAllByLimit(startIndex, pageSize);
        model.addAttribute("db_list_employees", dbListEmployees);
        model.addAttribute("totalPageCount", page.getTotalPageCount());
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("currPageNo", page.getCurrPageNo());
        return "Employees/query_Employees";
    }

    /**
     * 分页查询
     * @param currPageNo
     * @param model
     * @return
     */
    @GetMapping("/queryEmployees/{currPageNo}")
    public String queryEmployees(
            @PathVariable(value="currPageNo",required=false) Integer currPageNo,
            Model model){
        currPageNo = currPageNo==null||currPageNo<=0?1:currPageNo;
        int totalCount = employeesService.getTotalCount();
        page.setPageSize(pageSize);
        page.setTotalCount(totalCount);
        page.setCurrPageNo(currPageNo);
        int startIndex = (currPageNo - 1) * pageSize;
        List<Employees> dbListEmployees = employeesService.queryAllByLimit(startIndex, pageSize);
        model.addAttribute("db_list_employees", dbListEmployees);
        model.addAttribute("totalPageCount", page.getTotalPageCount());
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("currPageNo", page.getCurrPageNo());
        return "Employees/query_Employees";
    }

    /**
     * 根据id查询员工信息并跳转到修改页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping(value="/queryEmployeesById/{id}")
    public String queryPositionById(
            @PathVariable("id")int id,Model model
    ){
        Employees dbListEmployees = employeesService.queryById(id);
        List<Employees> dbListEmployees2 = employeesService.findEmployeesObj();
        if(dbListEmployees != null && dbListEmployees2 != null) {
            model.addAttribute("db_list_employees", dbListEmployees);
            model.addAttribute("db_list_employees_2", dbListEmployees2);
        }
        return "Employees/update_Employees";
    }

    /**
     * 新增员工
     * @param employees
     * @return
     */
    @PostMapping(value="/addEmployees")
    public String addPosition(Employees employees) {
        employeesService.insert(employees);

        return "redirect:/Employees/toAdd";
    }

    /**
     * 修改员工信息
     * @param employees
     * @return
     */
    @PutMapping(value="/updateEmployees")
    public String updateEmployees(Employees employees) {
        employeesService.update(employees);

        return "redirect:/Employees/backQueryEmployees";
    }

    /**
     * 根据 ID 删除员工信息
     * @param id
     * @return
     * @throws Exception
     */
    @DeleteMapping(value="/deleteEmployees/{id}")
    public String deleteEmployees(@PathVariable("id")int id){
        employeesService.deleteById(id);
        return "redirect:/Employees/backQueryEmployees";
    }
}