package com.it.ssm.controller;


import com.github.pagehelper.PageInfo;
import com.it.ssm.pojo.Employee;
import com.it.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 查询所有的员工信息 -->/employee-->get
 * 查询员工的分页信息 -->/employee/page/1-->get
 * 根据id查询员工信息 -->/employee/1-->get
 * 跳转到添加页面 -->/to/add-->get
 * 添加员工信息 -->/employee-->post
 * 修改员工信息 -->/employee-->put
 * 删除员工信息 -->/employee/1-->delete
 */
@Controller
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employee/page/{pageNum}", method = RequestMethod.GET)
    public String getEmployeePage(@PathVariable("pageNum") Integer pageNum, Model model) {
        //获取员工的分页信息
        PageInfo<Employee> page = employeeService.getAllEmployeePage(pageNum);
        //将分页数据共享到请求域中
        model.addAttribute("page", page);
        return "employee_list";

    }


    //添加员工信息
    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public String addEmployee(Employee employee) {
        employeeService.addEmp(employee);
        System.out.println(employee);
        return "redirect:/employee/page/1";
    }


    //修改员工信息 步骤1 通过员工id 查找要修改的 并放到请求域中回显
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)//需要先通过get 查出员工信息 在进行修改
    public String updateEmp(@PathVariable("id") Integer id, Model model) {
        //根据 id 查询员工信息
        Employee employee = employeeService.getEmpById(id);
        System.out.println("1：" + employee);
        //将员工信息 共享到请求域中
        model.addAttribute("employee", employee);
        return "employee_update";
    }

    //修改员工信息 步骤2
    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    public String updateEmployee(Employee employee) {
        //修改员工信息
        System.out.println("2" + employee);
        employeeService.updateEmp(employee);
        return "redirect:/employee/page/1";
    }

    //删除员工信息
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public String deleteEmp(@PathVariable("id") Integer id) {
        //删除员工信息
        employeeService.deleteEmp(id);
        return "redirect:/employee/page/1";
    }

}
