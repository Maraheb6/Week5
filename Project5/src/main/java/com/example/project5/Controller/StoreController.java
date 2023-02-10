package com.example.project5.Controller;

import com.example.project5.ApiException.ApiException;
import com.example.project5.Model.Book;
import com.example.project5.Model.Customer;
import com.example.project5.Model.Store;
import com.example.project5.Service.StoreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/store")
public class StoreController {
    private final StoreService storeService;


    //Get all Store
    @GetMapping("/get")
    public ResponseEntity getStore(){
        List<Store> stores=storeService.getStore();
        return ResponseEntity.status(200).body(stores);
    }
    //Add new Store
    @PostMapping("/add")
    public ResponseEntity addStore(@Valid @RequestBody Store store ){
      storeService.addStore(store);
        return ResponseEntity.status(200).body("Store Added");
    }
    //Update Store
    @PutMapping("/update/{ID}")
    public ResponseEntity updateStore(@PathVariable Integer ID,@Valid@RequestBody Store store){
        boolean isUpdate= storeService.updateStore(ID,store);
        if(isUpdate) {
            return ResponseEntity.status(200).body("Store Updated");
        }
        throw new ApiException("Wrong Store Id");
    }
    //Delete Store
    @DeleteMapping("/delete/{ID}")
    public  ResponseEntity deleteStore(@PathVariable Integer ID){
        boolean isDelete= storeService.deleteStore(ID);
        if(isDelete) {
            return ResponseEntity.status(200).body("Store Deleted");
        }
        throw new ApiException("Wrong Store Id");
    }

    //Assign Store To Customer
    @PutMapping("/{store_id}/store/{customer_id}")
    public ResponseEntity assignStoreToCustomer(@PathVariable Integer store_id,@PathVariable Integer customer_id){
       storeService.assignStoreToCustomer(store_id,customer_id);
        return ResponseEntity.status(200).body("Assignment Don Successfully");
    }
    //1-endpoint that takes store id and return all the books
    @GetMapping("/allbook/{id}")
    public ResponseEntity getAllBookById(@PathVariable Integer id){
        List<Book> books=storeService.getAllBookById(id);
        return ResponseEntity.status(200).body(books);
    }
    // 2-endpoint thar takes store id and return all customers
    @GetMapping("/allcustomers/{id}")
    public ResponseEntity getAllCustomerById(@PathVariable Integer id){
        List<Customer> customers=storeService.getAllCustomerById(id);
        return ResponseEntity.status(200).body(customers);
    }
}
