package com.controller;

import com.pojo.Dept;
import com.service.DeptService;
import com.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 张滨
 * @time 2022/08/01 15:56
 */

@Controller
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping("/emp/depts")
    @ResponseBody
    public Msg getDepts(){
        List<Dept> depts = deptService.getDepts();
        return Msg.success().add("depts",depts);
    }
}
