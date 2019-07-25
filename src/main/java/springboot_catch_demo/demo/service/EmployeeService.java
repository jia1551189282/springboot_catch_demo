package springboot_catch_demo.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import springboot_catch_demo.demo.bean.Employee;
import springboot_catch_demo.demo.mapper.EmployeeMapper;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Cacheable(value = "emp")
    public Employee getEmpById(Integer id){
        System.out.println("查询" + id + "号员工");
        Employee emp = employeeMapper.getEmpById(id);
        return emp;
    }
    @CachePut(value = "emp",key = "#employee.id")
    public Employee updateEmp(Employee employee){
        System.out.println("更新" + employee.getId() + "号员工");
        employeeMapper.updateEmp(employee);
        return employee;
    }
    @CacheEvict(value = "emp",key = "#id",beforeInvocation = true)
    public void deleteEmp(Integer id){
        employeeMapper.deleteEmpById(id);
    }
}
