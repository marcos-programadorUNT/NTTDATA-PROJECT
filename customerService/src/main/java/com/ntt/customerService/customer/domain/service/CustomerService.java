package com.ntt.customerService.customer.domain.service;

import com.ntt.customerService.customer.domain.dto.CustomerDto;
import com.ntt.customerService.customer.domain.model.entity.BusinessCustomer;
import com.ntt.customerService.customer.domain.model.entity.Customer;
import com.ntt.customerService.customer.domain.model.entity.CustomerType;
import com.ntt.customerService.customer.domain.model.entity.PersonalCustomer;

import java.util.List;
import java.util.Optional;

/**
 * Service of Customer contains basic functions (CRUD)
 *
 */
public interface CustomerService {
    /**
     * Retrieves a list of all Customers
     *
     * @return List of Customer objects
     */
    List<Customer> getAll();

    /**
     * Retrieves a List of Customers based on their type.
     *
     * @param type The type of customers to retrieve (personal or business)
     * @return List of Customer objects matching the specified type.
     */
    List<Customer> getCustomersByType(String type);

    /**
     * Retrieves a Customer based on their id
     *
     * @param id The id of customer to retrieve
     * @return An Optional list of Customer objects, or empty if not found.
     */
    Optional<Customer> getCustomerById(Long id);

    /**
     * Creates a new Personal Customer
     *
     * @param personalCustomer The PersonalCustomer object to be created.
     * @return The created PersonaCustomer object.
     */
    PersonalCustomer createPersonalCustomer(PersonalCustomer personalCustomer);

    /**
     * Creates a new Business Customer
     *
     * @param businessCustomer The BusinessCustomer object to be created.
     * @return The created BusinessCustomer object.
     */
    BusinessCustomer createBusinessCustomer(BusinessCustomer businessCustomer);

    /**
     * Updates an existing Customer
     *
     * @param id The id of the customer to be updated.
     * @param updatedCustomer The CustomerDto containing the updated information
     * @return The updated Customer object.
     */
    Customer updateCustomer(Long id, CustomerDto updatedCustomer);

    /**
     * Deletes a Customer based on their id.
     *
     * @param id The id of the customer to be deleted.
     * @return The deleted Customer object.
     */
    Customer deleteCustomer(Long id);

}
