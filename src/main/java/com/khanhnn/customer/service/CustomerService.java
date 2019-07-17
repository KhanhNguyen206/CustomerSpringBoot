package com.khanhnn.customer.service;

import com.khanhnn.customer.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);

    Page <Customer> findAllByFirstNameContaining(String name, Pageable pageable);
}
