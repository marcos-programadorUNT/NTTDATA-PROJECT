package com.ntt.customerservice.customer.domain.repository;

import com.ntt.customerservice.customer.domain.model.entity.BusinessCustomer;
import com.ntt.customerservice.customer.domain.model.entity.Customer;
import com.ntt.customerservice.customer.domain.model.entity.CustomerType;
import com.ntt.customerservice.customer.domain.model.entity.PersonalCustomer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Customer Repository with its search functions.
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

  /**
   * Search a Customer by type.
   *
   * @param customerType Type of client, can be: personal - business.
   * @return List of Customer.
   */
  public List<Customer> findByCustomerType(CustomerType customerType);

  /**
   * Retrieves a PersonalCustomer based on his documentNumber.
   *
   * @param documentNumber Document Number of a personal customer.
   * @return PersonalCustomer found by his matching document number.
   */
  public PersonalCustomer findByDocumentNumber(String documentNumber);

  /**
   * Retrieves a BusinessCustomer based on his RUC.
   *
   * @param ruc RUC of a business customer.
   * @return BusinessCustomer found by his matching RUC.
   */
  public BusinessCustomer findByRuc(String ruc);
}
