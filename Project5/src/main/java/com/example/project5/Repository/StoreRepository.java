package com.example.project5.Repository;

import com.example.project5.Model.Customer;
import com.example.project5.Model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store,Integer> {
    Store findStoreById(Integer id);

}
