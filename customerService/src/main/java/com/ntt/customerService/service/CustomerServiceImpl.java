package com.ntt.customerService.service;

import com.ntt.customerService.customer.domain.dto.CustomerDto;
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
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }
    @Override
    public List<Customer> getCustomersByType(String type) {
        return customerRepository.findByCustomerType(type);
    }
    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }
    @Override
    public PersonalCustomer createPersonalCustomer(PersonalCustomer personalCustomer) {
        return customerRepository.save(personalCustomer);
    }
    @Override
    public BusinessCustomer createBusinessCustomer(BusinessCustomer businessCustomer) {
        return customerRepository.save(businessCustomer);
    }
    @Override
    public Customer updateCustomer(Long id, CustomerDto updatedCustomer) {
        Customer customer= customerRepository.findById(id).orElse(null);
        if (customer != null){
            customer.setEmail(updatedCustomer.getEmail());
            customer.setAddress(updatedCustomer.getAddress());
            customer.setStatus(updatedCustomer.getStatus());
            if (customer instanceof PersonalCustomer) {
                PersonalCustomer personalCustomer = (PersonalCustomer) customer;

                personalCustomer.setDateOfBirth(updatedCustomer.getDateOfBirth());
                personalCustomer.setDocumentNumber(updatedCustomer.getDocumentNumber());
                personalCustomer.setPhoneNumber(updatedCustomer.getPhoneNumber());
                personalCustomer.setLastName(updatedCustomer.getLastName());
                personalCustomer.setFirstName(updatedCustomer.getFirstName());

                return customerRepository.save(customer);
            } else if (customer  instanceof BusinessCustomer) {
                BusinessCustomer businessCustomer = (BusinessCustomer) customer;
                businessCustomer.setBusinessName(updatedCustomer.getBusinessName());
                businessCustomer.setRuc(updatedCustomer.getRuc());
                businessCustomer.setFoundationDate(updatedCustomer.getFoundationDate());

                return customerRepository.save(customer);
            }
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

}
