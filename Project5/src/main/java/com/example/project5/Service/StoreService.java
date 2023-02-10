package com.example.project5.Service;

import com.example.project5.ApiException.ApiException;
import com.example.project5.Model.Book;
import com.example.project5.Model.Customer;
import com.example.project5.Model.Store;
import com.example.project5.Repository.BookRepository;
import com.example.project5.Repository.CustomerRepository;
import com.example.project5.Repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;

    private final CustomerRepository customerRepository;

    private final BookRepository bookRepository;

    //Get all Store
    public List<Store> getStore(){
        return storeRepository.findAll();
    }

    //Add new Store
    public void addStore(Store store){
        storeRepository.save(store);
    }

    //Update Store
    public boolean updateStore(Integer ID,Store store){
        Store oldStore=storeRepository.findStoreById(ID);
        if(oldStore==null){
            return false;
        }
        oldStore.setName(store.getName());
        storeRepository.save(oldStore);
        return true;
    }
    //Delete Store
    public boolean deleteStore(Integer ID){
        Store oldStore=storeRepository.findStoreById(ID);
        if(oldStore==null){
            return false;
        }
        storeRepository.delete(oldStore);
        return true;
    }
    //Assign Store To Customer
    public void assignStoreToCustomer(Integer store_id,Integer customer_id){
        Store store=storeRepository.findStoreById(store_id) ;
        Customer customer=customerRepository.findCustomerById(customer_id);
        if(store==null||customer==null){
            throw new ApiException("Wrong Data ");
        }
        store.getCustomers().add(customer);
        customer.getStores().add(store);
        storeRepository.save(store);
        customerRepository.save(customer);
    }

    //1-endpoint that takes store id and return all the books

    public List<Book> getAllBookById(Integer id){
        Store store=storeRepository.findStoreById(id);
        if(store==null){
            throw new ApiException("Store Id Not Found");
        }
        List<Book> books=bookRepository.findAllByStoreId(id);
        return books;
    }

   // 2-endpoint thar takes store id and return all customers
    public List<Customer> getAllCustomerById(Integer id){
        Store store=storeRepository.findStoreById(id);
        if(store==null){
            throw new ApiException("Store Id Not Found");
        }
        List<Customer> customers=customerRepository.findAllByStoresId(id);
        return customers;
    }

}
