package com.ntt.customerService.customer.domain.service;

import com.ntt.customerService.customer.domain.model.entity.BusinessCustomer;
import com.ntt.customerService.customer.domain.model.entity.Customer;
import com.ntt.customerService.customer.domain.model.entity.PersonalCustomer;

import java.util.List;
import java.util.Optional;

/**
 * implememtnacion de metodos
 */
public interface CustomerService {
    public PersonalCustomer createPersonalCustomer(PersonalCustomer personalCustomer);

    public BusinessCustomer createBusinessCustomer(BusinessCustomer businessCustomer);

    public List<Customer> getAll();

    public Optional<Customer> getCustomerById(Long id);

    public Customer updateCustomer(Customer updatedCustomer);

    public Customer deleteCustomer(Long id);

    public List<Customer> getCustomersByType(String type);
}
