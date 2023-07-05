package com.example.employeeaddress.Controller;

import com.example.employeeaddress.Model.Address;
import com.example.employeeaddress.Model.Employee;
import com.example.employeeaddress.Service.AddressService;
import com.example.employeeaddress.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping("getAllAddresses")
    public List<Address> getAllAddresses(){
        return addressService.getAllAddresses();
    }

    @GetMapping("getAddressById/{id}")
    public Address getAddressById(@PathVariable Long id){
        return addressService.getAddressById(id);
    }

    @PostMapping("addAddress")
    public String addAddress(@RequestBody Address address){
        return addressService.addAddress(address);
    }

    @PutMapping("updateAddress/{id}")
    public String updateAddress(@RequestBody Address address,@PathVariable Long id){
        return addressService.updateAddress(id,address);
    }

    @DeleteMapping("deleteAddressById/{id}")
    public String deleteAddressById(@PathVariable long id){
        return addressService.deleteAddressById(id);
    }
}
