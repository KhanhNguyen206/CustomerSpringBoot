package com.khanhnn.customer.service.impl;

import com.khanhnn.customer.model.Customer;
import com.khanhnn.customer.repository.CustomerRepository;
import com.khanhnn.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Page <Customer> findAllByFirstNameContaining(String name, Pageable pageable) {
        return customerRepository.findAllByFirstNameContaining(name, pageable);
    }
}
