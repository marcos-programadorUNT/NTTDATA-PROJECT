package com.ntt.customerService.customer.domain.service;

import com.ntt.customerService.customer.domain.dto.CustomerDto;
import com.ntt.customerService.customer.domain.model.entity.BusinessCustomer;
import com.ntt.customerService.customer.domain.model.entity.Customer;
import com.ntt.customerService.customer.domain.model.entity.PersonalCustomer;

import java.util.List;
import java.util.Optional;

/**
 * implememtnacion de metodos
 */
public interface CustomerService {
    List<Customer> getAll();
    List<Customer> getCustomersByType(String type);
    Optional<Customer> getCustomerById(Long id);
    PersonalCustomer createPersonalCustomer(PersonalCustomer personalCustomer);
    BusinessCustomer createBusinessCustomer(BusinessCustomer businessCustomer);
    Customer updateCustomer(Long id, CustomerDto updatedCustomer);
    Customer deleteCustomer(Long id);

}
