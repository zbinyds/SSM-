package com.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.EmpMapper;
import com.pojo.Emp;
import com.pojo.EmpExample;
import com.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张滨
 * @time 2022/07/30 18:14
 */

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Emp> getAllEmp() {
        return empMapper.selectByExampleWithDept(null);
    }

    @Override
    public PageInfo<Emp> pageEmp(Integer pid) {
        PageHelper.startPage(pid, 10);
        List<Emp> empList = getAllEmp();
        PageInfo<Emp> pageInfo = new PageInfo<>(empList, 5);
        return pageInfo;
    }

    @Override
    public Integer saveEmp(Emp emp) {
        int i = empMapper.insertSelective(emp);
        return i;
    }

    @Override
    public Emp getEmpByEditId(Integer empId) {
        Emp emp = empMapper.selectByPrimaryKeyWithDept(empId);
        return emp;
    }

    @Override
    public void updateEmp(Emp emp) {
        empMapper.updateByPrimaryKeySelective(emp);
    }

    @Override
    public void deleteEmp(String empName) {
        EmpExample empExample = new EmpExample();
        empExample.createCriteria().andEmpNameEqualTo(empName);
        empMapper.deleteByExample(empExample);
    }

    @Override
    public void deleteEmpBatch(List<String> nameList) {
        EmpExample empExample = new EmpExample();
        empExample.createCriteria().andEmpNameIn(nameList);
        empMapper.deleteByExample(empExample);
    }

}
