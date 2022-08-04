package com.service.impl;

import com.mapper.DeptMapper;
import com.pojo.Dept;
import com.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张滨
 * @time 2022/08/01 15:57
 */

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> getDepts() {
        List<Dept> depts = deptMapper.selectByExample(null);
        return depts;
    }
}
