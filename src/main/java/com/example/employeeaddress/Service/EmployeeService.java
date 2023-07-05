package com.example.employeeaddress.Service;

import com.example.employeeaddress.Model.Employee;
import com.example.employeeaddress.Repo.IEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    IEmployeeRepo iEmployeeRepo;

    public List<Employee> getAllEmployees() {
        return (List<Employee>) iEmployeeRepo.findAll();
    }

    public Employee getEmployeeById(Long id) {
        if(iEmployeeRepo.existsById(id)){
            return iEmployeeRepo.findById(id).get();
        }
        return null;
    }

    public String addEmployee(Employee employee) {
        iEmployeeRepo.save(employee);
        return "Employee Added";
    }

    public String updateEmployee(Long id, Employee employee) {
        Employee oldEmployee = getEmployeeById(id);
        if(oldEmployee!=null){
            if(employee.getAddress()!=null){
                if(employee.getAddress().getStreet()!=null)
                    oldEmployee.getAddress().setStreet(employee.getAddress().getStreet());
                if(employee.getAddress().getCity()!=null)
                    oldEmployee.getAddress().setCity(employee.getAddress().getCity());
                if(employee.getAddress().getState()!=null)
                    oldEmployee.getAddress().setState(employee.getAddress().getState());
                if(employee.getAddress().getZipCode()!=null)
                    oldEmployee.getAddress().setZipCode(employee.getAddress().getZipCode());
            }
            if(employee.getLastName()!=null)
                oldEmployee.setLastName(employee.getLastName());
            if(employee.getFirstName()!=null)
                oldEmployee.setFirstName(employee.getFirstName());
            iEmployeeRepo.save(oldEmployee);
            return "Employee Updated";
        }
        return "Employee not found";
    }

    public String deleteEmployeeById(long id) {
        if(iEmployeeRepo.existsById(id)){
            iEmployeeRepo.deleteById(id);
            return "Deleted";
        }
        return "Employee not found";
    }
}
