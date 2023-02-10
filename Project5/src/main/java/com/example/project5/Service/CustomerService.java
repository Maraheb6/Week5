package com.example.project5.Service;

import com.example.project5.ApiException.ApiException;
import com.example.project5.Model.Customer;
import com.example.project5.Model.Store;
import com.example.project5.Repository.CustomerRepository;
import com.example.project5.Repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;


    //Get all Customer
    public List<Customer> getCustomer(){
        return customerRepository.findAll();
    }

    //Add new Customer
    public void addCustomer(Customer customer){
        customerRepository.save(customer);
    }

    //Update Customer
    public boolean updateCustomer(Integer ID,Customer customer){
        Customer oldCustomer=customerRepository.findCustomerById(ID);
        if(oldCustomer==null){
            return false;
        }

        oldCustomer.setName(customer.getName());
        oldCustomer.setPhoneNumber(customer.getPhoneNumber());
        oldCustomer.setEmail(customer.getEmail());


       customerRepository.save(oldCustomer);
        return true;
    }
    //Delete Customer
    public boolean deleteCustomer(Integer ID){
        Customer oldCustomer=customerRepository.findCustomerById(ID);
        if(oldCustomer==null){
            return false;
        }
        customerRepository.delete(oldCustomer);
        return true;
    }

}
