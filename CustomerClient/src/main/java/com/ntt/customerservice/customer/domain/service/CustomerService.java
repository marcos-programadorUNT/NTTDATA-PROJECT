package com.ntt.customerservice.customer.domain.service;

import com.ntt.customerservice.customer.domain.dto.CustomerDto;
import com.ntt.customerservice.customer.domain.model.entity.BusinessCustomer;
import com.ntt.customerservice.customer.domain.model.entity.Customer;
import com.ntt.customerservice.customer.domain.model.entity.PersonalCustomer;
import java.util.List;

/**
 * Service of Customer contains basic functions (CRUD).
 *
 */
public interface CustomerService {

  /**
   * Retrieves a list of all Customers.
   *
   * @return List of Customer objects.
   */
  List<Customer> getAll();

  /**
   * Retrieves a List of Customers based on their type.
   *
   * @param type The type of customers to retrieve (personal or business).
   * @return List of Customer objects matching the specified type.
   */
  List<Customer> getCustomersByType(String type);

  /**
   * Retrieves a Customer based on his documentNumber.
   *
   * @param documentNumber Document Number of a personal customer.
   * @return PersonalCustomer found by his matching document number.
   */
  PersonalCustomer getCustomerByDocumentNumber(String documentNumber);

  /**
   * Retrieves a Customer based on his RUC.
   *
   * @param ruc RUC of a business customer.
   * @return BusinessCustomer found by his matching RUC.
   */
  BusinessCustomer getCustomerByRuc(String ruc);

  /**
   * Retrieves a Customer based on their id.
   *
   * @param id The id of customer to retrieve.
   * @return A Customer object, or empty if not found.
   */
  Customer getCustomerById(Long id);

  /**
   * Creates a new Personal Customer.
   *
   * @param personalCustomer The PersonalCustomer object to be created.
   * @return The created PersonalCustomer object.
   */
  PersonalCustomer createPersonalCustomer(PersonalCustomer personalCustomer);

  /**
   * Creates a new Business Customer.
   *
   * @param businessCustomer The BusinessCustomer object to be created.
   * @return The created BusinessCustomer object.
   */
  BusinessCustomer createBusinessCustomer(BusinessCustomer businessCustomer);

  /**
   * Updates an existing Customer.
   *
   * @param id The id of the customer to be updated.
   * @param updatedCustomer The CustomerDto containing the updated information.
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
