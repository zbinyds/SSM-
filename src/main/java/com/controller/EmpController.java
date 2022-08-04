package com.controller;

import com.github.pagehelper.PageInfo;
import com.pojo.Emp;
import com.service.EmpService;
import com.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * @author 张滨
 * @time 2022/07/30 18:13
 */

@Controller()
public class EmpController {

    @Autowired
    private EmpService empService;

    /**
     * 请求方式为Get，表示获取员工信息
     * @param pid
     * @return
     */
    @RequestMapping(value = "/emp/{pid}", method = RequestMethod.GET)
    @ResponseBody
    public Msg getEmpList(@PathVariable("pid") Integer pid) {
        PageInfo<Emp> pageInfo = empService.pageEmp(pid);
//        System.out.println(pageInfo);
        return new Msg().success().add("pageInfo", pageInfo);
    }

    /**
     * 请求方式为POST，表示添加员工
     * @param emp
     * @return
     */
    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    @ResponseBody
    public Msg saveEmp(@RequestBody Emp emp) {
        System.out.println("即将添加的emp：" + emp);
        Integer row = empService.saveEmp(emp);
        return new Msg().success();
    }

    /**
     * 请求方式为PUT，表示修改员工信息
     * @param emp
     * @return
     */
    @RequestMapping(value = "/emp", method = RequestMethod.PUT)
    @ResponseBody
    public Msg updateEmp(@RequestBody Emp emp) {
        System.out.println("修改后的emp：" + emp);
        empService.updateEmp(emp);
        return new Msg().success();
    }

    /**
     * 请求方式为DELETE，表示删除员工（支持批量删除）
     * @param empNames
     * @return
     */
    @RequestMapping(value = "/emp/{empNames}", method = RequestMethod.DELETE)
    @ResponseBody
    public Msg deleteEmp(@PathVariable("empNames") String empNames) {
        System.out.println("即将删除的员工：【" + empNames + "】");
        // 批量删除
        if (empNames.contains(",")){
            String[] empNameList = empNames.split(",");
            empService.deleteEmpBatch(Arrays.asList(empNameList));

        } else{ // 单个删除
            empService.deleteEmp(empNames);
        }
        return new Msg().success();
    }

    /**
     * 获取正在编辑的用户信息
     * @param empId
     * @return
     */
    @RequestMapping(value = "/emp/edit", method = RequestMethod.GET)
    @ResponseBody
    public Msg getEditEmp(@RequestParam("empId") Integer empId) {
        Emp emp = empService.getEmpByEditId(empId);
        return new Msg().success().add("editEmp", emp);
    }


//    /**
//     * 传统写法，返回渲染好的视图呈现给用户
//     * @param pid
//     * @param model
//     * @return
//     */
//    @RequestMapping(value = "/emp/empList/{pid}", method = RequestMethod.GET)
//    public String getEmpList(@PathVariable("pid") Integer pid, Model model) {
//        PageInfo<Emp> pageInfo = empService.pageEmp(pid);
//        System.out.println(pageInfo);
//        model.addAttribute("pageInfo", pageInfo);
//        return "empList";
//    }
}
