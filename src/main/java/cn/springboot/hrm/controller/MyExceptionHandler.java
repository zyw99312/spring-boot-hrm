package cn.springboot.hrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author zyw
 */
@Controller
@RequestMapping("/errorPage")
public class MyExceptionHandler {

  @GetMapping("/{code}")
  public String toErrorPage(@PathVariable int code,Model model) {
    model.addAttribute("code",code);
    return "Error/error";
  }

}