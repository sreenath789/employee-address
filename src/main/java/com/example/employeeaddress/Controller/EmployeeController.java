package com.example.employeeaddress.Controller;

import com.example.employeeaddress.Model.Employee;
import com.example.employeeaddress.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
//    GET /employees - get all employees
//    GET /employees/{id} - get an employee by id
//    POST /employees - create a new employee
//    PUT /employees/{id} - update an employee by id
//    DELETE /employees/{id} - delete an employee by id
    @Autowired
    EmployeeService employeeService;

    @GetMapping("getAllEmployees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("getEmployeeById/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("addEmployee")
    public String addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @PutMapping("updateEmployee/{id}")
    public String updateEmployee(@RequestBody Employee employee,@PathVariable Long id){
        return employeeService.updateEmployee(id,employee);
    }

    @DeleteMapping("deleteEmployeeById/{id}")
    public String deleteEmployeeById(@PathVariable long id){
        return employeeService.deleteEmployeeById(id);
    }


}
