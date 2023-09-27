package com.ntt.customerService.service;

import com.ntt.customerService.customer.domain.dto.CustomerDto;
import com.ntt.customerService.customer.domain.model.entity.BusinessCustomer;
import com.ntt.customerService.customer.domain.model.entity.Customer;
import com.ntt.customerService.customer.domain.model.entity.CustomerType;
import com.ntt.customerService.customer.domain.model.entity.PersonalCustomer;
import com.ntt.customerService.customer.domain.repository.CustomerRepository;
import com.ntt.customerService.customer.domain.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 * Implementation of service methods of Customer, contains basic functions (CRUD)
 *
 */
@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    /**
     * Retrieves a list of all Customers
     *
     * @return List of Customer objects
     */
    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    /**
     * Retrieves a List of Customers based on their type.
     *
     * @param type The type of customers to retrieve (personal or business)
     * @return List of Customer objects matching the specified type.
     */
    @Override
    public List<Customer> getCustomersByType(String type) {
        return customerRepository.findByCustomerType(CustomerType.valueOf(type));
    }
    /**
     * Retrieves a Customer based on their id
     *
     * @param id The id of customer to retrieve
     * @return An Optional list of Customer objects, or empty if not found.
     */
    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }
    /**
     * Creates a new Personal Customer
     *
     * @param personalCustomer The PersonalCustomer object to be created.
     * @return The created PersonaCustomer object.
     */
    @Override
    public PersonalCustomer createPersonalCustomer(PersonalCustomer personalCustomer) {
        return customerRepository.save(personalCustomer);
    }
    /**
     * Creates a new Business Customer
     *
     * @param businessCustomer The BusinessCustomer object to be created.
     * @return The created BusinessCustomer object.
     */
    @Override
    public BusinessCustomer createBusinessCustomer(BusinessCustomer businessCustomer) {
        return customerRepository.save(businessCustomer);
    }
    /**
     * Updates an existing Customer
     *
     * @param id The id of the customer to be updated.
     * @param updatedCustomer The CustomerDto containing the updated information
     * @return The updated Customer object.
     */
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
    /**
     * Deletes a Customer based on their id.
     *
     * @param id The id of the customer to be deleted.
     * @return The deleted Customer object.
     */
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
