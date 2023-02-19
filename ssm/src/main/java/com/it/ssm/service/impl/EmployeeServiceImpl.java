package com.it.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.ssm.mapper.EmployeeMapper;
import com.it.ssm.pojo.Employee;
import com.it.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeMapper.getAllEmployee();
    }

    @Override
    public PageInfo<Employee> getAllEmployeePage(Integer pageNum) {
        //开启分页功能
        PageHelper.startPage(pageNum, 4);
        //查询所有的员工信息
        List<Employee> list = employeeMapper.getAllEmployee();
        //获取分页相关数据
        PageInfo<Employee> page = new PageInfo<>(list, 5);
        return page;
    }

    @Override
    public void addEmp(Employee employee) {
        int i = employeeMapper.addEmp(employee);
        System.out.println("成功添加数据！" + i);
        return;
    }

    @Override
    public Employee getEmpById(Integer id) {
        Employee emp = employeeMapper.getEmpById(id);
        return emp;
    }

    @Override
    public void updateEmp(Employee employee) {
        employeeMapper.updateEmp(employee);
        return;
    }

    @Override
    public void deleteEmp(Integer id) {
        employeeMapper.deleteEmp(id);
        return;
    }

}
