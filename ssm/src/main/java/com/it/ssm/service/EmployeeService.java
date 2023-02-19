package com.it.ssm.service;

import com.github.pagehelper.PageInfo;
import com.it.ssm.pojo.Employee;

import java.util.List;

public interface EmployeeService {

    //查询所有员工信息
    List<Employee> getAllEmployee();

    //获取员工的分页信息
    PageInfo<Employee> getAllEmployeePage(Integer pageNum);

    void addEmp(Employee employee);

    Employee getEmpById(Integer id);

    void updateEmp(Employee employee);

    void deleteEmp(Integer id);
}
