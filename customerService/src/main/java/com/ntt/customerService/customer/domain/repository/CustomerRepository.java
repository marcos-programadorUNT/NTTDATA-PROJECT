package com.ntt.customerService.customer.domain.repository;

import com.ntt.customerService.customer.domain.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByCustomerType(String customerType);
}
