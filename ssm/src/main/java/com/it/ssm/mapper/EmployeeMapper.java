package com.it.ssm.mapper;

import com.it.ssm.pojo.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeMapper {
    List<Employee> getAllEmployee();

    int addEmp(@Param("employee") Employee employee);

    //通过id 查询员工信息
    Employee getEmpById(@Param("id") Integer id);

    //更新员工信息
    void updateEmp(@Param("employee") Employee employee);

    void deleteEmp(@Param("id") Integer id);

}
