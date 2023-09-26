package com.ntt.customerService.customer.domain.repository;

import com.ntt.customerService.customer.domain.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

/**
 * Customer Repository with its search functions
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    /**
     * Search a Customer by type
     * @param customerType Type of client, can be: personal - business
     * @return List of Customer
     */
    List<Customer> findByCustomerType(String customerType);
}
