package cn.springboot.hrm.controller;

import cn.springboot.hrm.entity.Admin;
import cn.springboot.hrm.entity.Page;
import cn.springboot.hrm.entity.ResultMap;
import cn.springboot.hrm.service.AdminService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Admin)表控制层
 *
 * @author zyw
 * @since 2020-03-26 19:18:38
 */

@Controller
@RequestMapping("Admin")
public class AdminController {
    /**
     * 服务对象
     */
    @Resource
    private AdminService adminService;

    private List<Admin> dbListAdmin = new ArrayList<>();
    private Page page = new Page();
    private int pageSize = 5;
    /**
     * 跳转到新增页面
     * @return view
     */
    @GetMapping("/toAdd")
    public String toAdd(){
        return "Admin/add_Admin";
    }
    @GetMapping("/toQuery")
    public String toQuery(){
        return "Admin/query_Admin";
    }

    @GetMapping("/backQueryAdmin")
    public String backQueryPage(@RequestParam(value="currPageNo",required=false) Integer currPageNo,Model model){
        currPageNo = currPageNo==null||currPageNo<=0?1:currPageNo;
        int totalCount = adminService.getTotalCount();
        page.setPageSize(pageSize);
        page.setTotalCount(totalCount);
        page.setCurrPageNo(currPageNo);
        int startIndex = (currPageNo - 1) * pageSize;
        dbListAdmin = adminService.queryAllByLimit(startIndex,pageSize);
        model.addAttribute("db_list_admin", dbListAdmin);
        model.addAttribute("totalPageCount", page.getTotalPageCount());
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("currPageNo", page.getCurrPageNo());

        return "Admin/query_Admin";
    }

    /**
     * 查询所有管理员信息
     * @return view
     */
    @GetMapping("/queryAdmin/{currPageNo}")
    public String queryAllAdmin(@PathVariable(value="currPageNo",required = false) Integer currPageNo,Model model){
        currPageNo = currPageNo==null||currPageNo<=0?1:currPageNo;
        int totalCount = adminService.getTotalCount();
        page.setPageSize(pageSize);
        page.setTotalCount(totalCount);
        page.setCurrPageNo(currPageNo);
        int startIndex = (currPageNo - 1) * pageSize;

        dbListAdmin = adminService.queryAllByLimit(startIndex,pageSize);
        model.addAttribute("db_list_admin", dbListAdmin);
        model.addAttribute("totalPageCount", page.getTotalPageCount());
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("currPageNo", page.getCurrPageNo());

        return "Admin/query_Admin";
    }


    /**
     * 根据id查询结果并大送到修改页面
     * @param id id
     * @param model model
     * @return view
     */
    @GetMapping("/queryAdminById/{id}")
    public String queryAdminById(@PathVariable("id")int id, Model model){

        Admin dbAdmin =  adminService.queryById(id);
        if(dbAdmin != null) {
            model.addAttribute("db_list_admin", dbAdmin);
            return "Admin/update_Admin";
        }
        return "Admin/query_Admin";
    }

    /**
     * 新增用户
     * @param admin 对象
     * @return view
     */
    @PostMapping("/addAdmin")
    public String addAdmin(Admin admin){
        adminService.insert(admin);
        return "Admin/add_Admin";
    }
    /**
     * 修改admin
     * @param admin 对象
     * @return view
     */
    @PutMapping("/updateAdmin")
    public String updateAdmin(Admin admin){
        adminService.update(admin);
        return "redirect:/Admin/backQueryAdmin";
    }

    /**
     * 根据id删除用户
     * @param id id
     * @return view
     */
    @DeleteMapping("/deleteAdmin/{id}")
    public String deleteAdmin(@PathVariable("id")int id){
        adminService.deleteById(id);
        return "redirect:/Admin/backQueryAdmin";
    }

}