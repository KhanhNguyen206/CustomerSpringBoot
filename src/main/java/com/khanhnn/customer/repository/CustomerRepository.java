package com.khanhnn.customer.repository;

import com.khanhnn.customer.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

    Page<Customer> findAllByFirstNameContaining(String s, Pageable pageable);

}
