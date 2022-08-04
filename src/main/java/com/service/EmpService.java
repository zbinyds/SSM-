package com.service;
import com.github.pagehelper.PageInfo;
import com.pojo.Emp;
import java.util.List;

/**
 * @author 张滨
 * @time 2022/07/30 18:14
 */

public interface EmpService {

    /**
     * 获取所有的员工信息
     * @return
     */
    List<Emp> getAllEmp();

    /**
     * 完成分页功能
     * @return
     */
    PageInfo<Emp> pageEmp(Integer pid);

    /**
     * 新增员工
     */
    Integer saveEmp(Emp emp);

    /**
     * 获取正在编辑的员工信息
     * @param empId
     * @return
     */
    Emp getEmpByEditId(Integer empId);

    /**
     * 修改员工信息
     * @param emp
     */
    void updateEmp(Emp emp);

    /**
     * 删除员工
     * @param empName
     */
    void deleteEmp(String empName);

    void deleteEmpBatch(List<String> nameList);
}
