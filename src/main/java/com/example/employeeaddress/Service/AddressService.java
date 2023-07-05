package com.example.employeeaddress.Service;

import com.example.employeeaddress.Model.Address;
import com.example.employeeaddress.Repo.IAddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    IAddressRepo iAddressRepo;
    public List<Address> getAllAddresses() {
        return (List<Address>) iAddressRepo.findAll();
    }

    public Address getAddressById(Long id) {
        if(iAddressRepo.existsById(id)){
            return iAddressRepo.findById(id).get();
        }
        return null;
    }

    public String addAddress(Address address) {
        iAddressRepo.save(address);
        return "Address Added";
    }

    public String updateAddress(Long id, Address address) {
        Address oldAddress = getAddressById(id);
        if(oldAddress!=null){
            if(address.getStreet()!=null)
                oldAddress.setStreet(address.getStreet());
            if(address.getCity()!=null)
                oldAddress.setCity(address.getCity());
            if(address.getZipCode()!=null)
                oldAddress.setZipCode(address.getZipCode());
            iAddressRepo.save(oldAddress);
            return "Address Updated";
        }
        return "Address not found";
    }

    public String deleteAddressById(long id) {
        if(iAddressRepo.existsById(id)){
            iAddressRepo.deleteById(id);
            return "Deleted";
        }
        return "Address not found";
    }
}
