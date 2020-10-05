package com.example.flywaydemo.repository;

import com.example.flywaydemo.dto.OrderResponse;
import com.example.flywaydemo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("select new com.example.flywaydemo.dto.OrderResponse(c.name, p.productName) from Customer c join c.products p")
    List<OrderResponse> getJoinInformation();
}
