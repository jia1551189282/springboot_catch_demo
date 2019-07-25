package springboot_catch_demo.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springboot_catch_demo.demo.bean.Employee;
import springboot_catch_demo.demo.service.EmployeeService;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @RequestMapping("/employee/{id}")
    @ResponseBody
    public Employee getEmpById(@PathVariable("id") Integer id){
        Employee emp = employeeService.getEmpById(id);
        return emp;
    }
    @RequestMapping("/employee/update")
    @ResponseBody
    public String updateEmp(Employee employee){
        employeeService.updateEmp(employee);
        return  "sussess";
    }
    @RequestMapping("/employee/delete")
    @ResponseBody
    public String deleteEmp(int id){
        employeeService.deleteEmp(id);
        return "删除成功";
    }
}
