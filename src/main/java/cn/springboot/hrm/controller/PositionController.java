package cn.springboot.hrm.controller;

import cn.springboot.hrm.entity.Page;
import cn.springboot.hrm.entity.Position;
import cn.springboot.hrm.service.PositionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Position)表控制层
 *
 * @author zyw
 * @since 2020-03-26 19:18:40
 */
@Controller
@RequestMapping("Position")
public class PositionController {
    /**
     * 服务对象
     */
    @Resource
    private PositionService positionService;
    private Page page = new Page();
    private int pageSize = 5;

    /**
     * 获取已有的部门并跳转到新增页面
     * @param model model
     * @return view
     */
    @GetMapping("/toAdd")
    public String toAdd(Model model){
        List<Position> dbListPosition =  positionService.findPositionObj();
        if(dbListPosition != null) {
            model.addAttribute("db_list_position", dbListPosition);
        }
        return "Position/add_Position";
    }

    /**
     * 返回查询列表页面
     * @param currPageNo 当前页面数
     * @param model model
     * @return view
     */
    @GetMapping("/backQueryPosition")
    public String backQueryPosition(@RequestParam(value = "currPageNo",required = false) Integer currPageNo,Model model){
        currPageNo = currPageNo==null||currPageNo<=0?1:currPageNo;
        int totalCount = positionService.getTotalCount();
        page.setPageSize(pageSize);
        page.setTotalCount(totalCount);
        page.setCurrPageNo(currPageNo);
        int startIndex = (currPageNo - 1) * pageSize;
        List<Position> dbListPosition = positionService.queryAllByLimit(startIndex, pageSize);
        model.addAttribute("db_list_position", dbListPosition);
        model.addAttribute("totalPageCount", page.getTotalPageCount());
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("currPageNo", page.getCurrPageNo());

        return "Position/query_Position";
    }

    /**
     * 分页查询所有职位信息
     * @param currPageNo 当前页面数
     * @param model model
     * @return view
     */
    @GetMapping("/queryPosition/{currPageNo}")
    public String queryPosition(@PathVariable("currPageNo") Integer currPageNo,Model model){
        currPageNo = currPageNo==null||currPageNo<=0?1:currPageNo;
        int totalCount = positionService.getTotalCount();
        page.setPageSize(pageSize);
        page.setTotalCount(totalCount);
        page.setCurrPageNo(currPageNo);
        int startIndex = (currPageNo - 1) * pageSize;
        List<Position> dbListPosition = positionService.queryAllByLimit(startIndex, pageSize);
        model.addAttribute("db_list_position", dbListPosition);
        model.addAttribute("totalPageCount", page.getTotalPageCount());
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("currPageNo", page.getCurrPageNo());

        return "Position/query_Position";
    }

    /**
     * 根据id查询职位并跳转到修改页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping(value="/queryPositionById/{id}")
    public String queryPositionById(@PathVariable("id")int id,Model model){

        Position dbListPosition = positionService.queryById(id);
        List<Position> dbListPosition2 = positionService.findPositionName();
        if(dbListPosition != null && dbListPosition2 != null) {
            model.addAttribute("db_list_position", dbListPosition);
            model.addAttribute("db_list_position_2", dbListPosition2);
        }
        return "Position/update_Position";
    }


    /**
     * 新增职位
     * @param departmentName
     * @param positionName
     * @param baseSalary
     * @return
     */
    @PostMapping("/addPosition")
    public String addPosition(
            @RequestParam("departmentName") String departmentName,
            @RequestParam("positionName") String positionName,
            @RequestParam("baseSalary") Double baseSalary){

        Position position = new Position();
        List<Position> db_list_departmentObj = positionService.getPositionObjByDepartmentName(departmentName);
        for(Position p:db_list_departmentObj) {
            String a = p.getDepartment().getDepartmentno();
            position.setDepartmentobj(a);
        }
        position.setPositionname(positionName);
        position.setBasesalary(baseSalary);
        positionService.insert(position);

        return "redirect:/Position/toAdd";
    }

    /**
     * 修改职位信息并返回查询列表
     * @param position
     * @return
     */
    @PutMapping("/updatePosition")
    public String updatePosition(Position position) {
        positionService.update(position);
        return "redirect:/Position/backQueryPosition";
    }

    /**
     * 根据id删除职位信息并返回查询列表
     * @param id
     * @return
     * @throws Exception
     */
    @DeleteMapping(value="/deletePosition/{id}")
    public String deletePosition(@PathVariable("id")int id) throws Exception{
        positionService.deleteById(id);
        return "redirect:/Position/backQueryPosition";
    }

}