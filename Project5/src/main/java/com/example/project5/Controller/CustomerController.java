package com.example.project5.Controller;

import com.example.project5.ApiException.ApiException;
import com.example.project5.Model.Customer;
import com.example.project5.Service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;


    //Get all Customer
    @GetMapping("/get")
    public ResponseEntity getCustomer(){
        List<Customer> customers=customerService.getCustomer();
        return ResponseEntity.status(200).body(customers);
    }
    //Add new Customer
    @PostMapping("/add")
    public ResponseEntity addCustomer(@Valid @RequestBody Customer customer ){
        customerService.addCustomer(customer);
        return ResponseEntity.status(200).body("Customer Added");
    }
    //Update Customer
    @PutMapping("/update/{ID}")
    public ResponseEntity updateCustomer(@PathVariable Integer ID,@Valid@RequestBody Customer customer){
        boolean isUpdate= customerService.updateCustomer(ID,customer);
        if(isUpdate) {
            return ResponseEntity.status(200).body("Customer Updated");
        }
        throw new ApiException("Wrong Customer Id");
    }
    //Delete Customer
    @DeleteMapping("/delete/{ID}")
    public  ResponseEntity deleteCustomer(@PathVariable Integer ID){
        boolean isDelete= customerService.deleteCustomer(ID);
        if(isDelete) {
            return ResponseEntity.status(200).body("Customer Deleted");
        }
        throw new ApiException("Wrong  Customer Id");
    }

}
