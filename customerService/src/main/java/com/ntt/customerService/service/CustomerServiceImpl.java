package com.ntt.customerService.service;

import com.ntt.customerService.customer.domain.model.entity.BusinessCustomer;
import com.ntt.customerService.customer.domain.model.entity.Customer;
import com.ntt.customerService.customer.domain.model.entity.PersonalCustomer;
import com.ntt.customerService.customer.domain.repository.CustomerRepository;
import com.ntt.customerService.customer.domain.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Override
    public PersonalCustomer createPersonalCustomer(PersonalCustomer personalCustomer) {
        return customerRepository.save(personalCustomer);
    }

    @Override
    public BusinessCustomer createBusinessCustomer(BusinessCustomer businessCustomer) {
        return customerRepository.save(businessCustomer);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer updateCustomer(Customer updatedCustomer) {
        Optional<Customer> customerDb = getCustomerById(updatedCustomer.getId());
        if (customerDb.isEmpty()){
            return null;
        }


        return null;
    }

    @Override
    public Customer deleteCustomer(Long id) {
        Optional<Customer> customerDb = getCustomerById(id);
        if (customerDb.isEmpty()){
            return null;
        }
        Customer customerSelected = customerDb.get();
        customerSelected.setStatus("DELETED");
        return customerRepository.save(customerSelected);
    }
    @Override
    public List<Customer> getCustomersByType(String type) {
        return customerRepository.findByCustomerType(type);
    }

}
