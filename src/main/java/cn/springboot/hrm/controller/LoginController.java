package cn.springboot.hrm.controller;

import cn.springboot.hrm.entity.Admin;
import cn.springboot.hrm.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author zyw
 */
@Controller
public class LoginController {

    @Autowired
    AdminService adminService;

    @GetMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @GetMapping("/toMain")
    public String toMain(){
        return "main";
    }
    /**
     * 注销登录
     * @return login
     */
    @GetMapping("/logout")
    public String logout(){
        return "login";
    }

    /**
     * 验证登录
     * @param admin
     * @return
     */
    @PostMapping("/checkLogin")
    public String checkLogin(Admin admin, HttpSession session) {
        Admin admin1 = adminService.findAdminByNameAndPwd(admin);
        if (admin1==null){
            return "redirect:/toLogin";
        }else{
          //登陆成功，防止表单重复提交，可以重定向到主页
          session.setAttribute("loginUser",admin1);
          return "redirect:/toMain";
        }
    }
}
