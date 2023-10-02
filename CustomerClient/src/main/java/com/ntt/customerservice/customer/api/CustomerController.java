package com.ntt.customerservice.customer.api;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ntt.customerservice.customer.domain.dto.CustomerDto;
import com.ntt.customerservice.customer.domain.model.entity.BusinessCustomer;
import com.ntt.customerservice.customer.domain.model.entity.Customer;
import com.ntt.customerservice.customer.domain.model.entity.PersonalCustomer;
import com.ntt.customerservice.customer.domain.service.CustomerService;
import java.util.*;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;




/**
 * Generates the mapping of the REST functions for the Customer service API.
 *
 */
@AllArgsConstructor
@RestController
@RequestMapping("api/customers")
public class CustomerController {
  /**
   * Formats a BindingResult into a JSON-formatted error message.
   * This method takes a BindingResult object, extracts field errors, and constructs
   * an error message in a structured JSON format.
   *
   * @param result The BindingResult containing validation errors.
   * @return  A JSON-formatted error message as a String.
   */
  private String formatMessage(BindingResult result) {
    List<Map<String, String>> errors = result.getFieldErrors().stream()
        .map(err -> {
          Map<String, String> error = new HashMap<>();
          error.put(err.getField(), err.getDefaultMessage());
          return error;
        }).collect(Collectors.toList());

    ErrorMessage errorMessage = ErrorMessage.builder()
        .code("01")
        .messages(errors)
        .build();
    ObjectMapper mapper = new ObjectMapper();
    String jsonString = "";
    try {
      jsonString = mapper.writeValueAsString(errorMessage);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return jsonString;
  }

  /**
   * Service for Customer.
   *
   */
  private final CustomerService customerService;

  /**
   * Retrieves all customers.
   *
   * @return List of Customer objects.
   */
  @GetMapping
  public ResponseEntity<List<Customer>> fetchAll(
      @RequestParam(name = "customerId", required = false) Long customerId) {
    List<Customer> customers;
    if (Optional.ofNullable(customerId).isEmpty()) {
      customers = customerService.getAll();
    } else {
      customers = List.of(customerService.getCustomerById(customerId));
    }
    return ResponseEntity.ok(customers);
  }

  /**
   * Retrieves customers by their type (personal or business).
   *
   * @param type Type of customers to retrieve (personal or business).
   * @return List of Customer objects.
   */
  @GetMapping(value = "/{type}")
  public List<Customer> getCustomersByType(@PathVariable("type") String type) {
    return customerService.getCustomersByType(type);
  }

  /**
   * Retrieves a Customer by his Unique document.
   *
   * @param documentNumber Document Number of the personal customer.
   *
   * @param ruc RUC of the customer business.
   * @return Customer or 404 Not Found.
   */
  @GetMapping("/search")
  public Customer searchCustomer(
      @RequestParam(value = "documentNumber", required = false) String documentNumber,
      @RequestParam(value = "ruc", required = false) String ruc) {
    if (documentNumber != null && ruc != null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Insert only one parameter.");
    } else if (documentNumber != null) {
      PersonalCustomer personalCustomerFound = customerService
                                               .getCustomerByDocumentNumber(documentNumber);
      if (personalCustomerFound != null) {
        return personalCustomerFound;
      } else {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found.");
      }
    } else if (ruc != null) {
      BusinessCustomer businessCustomerFound = customerService.getCustomerByRuc(ruc);
      if (businessCustomerFound != null) {
        return businessCustomerFound;
      } else {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found.");
      }
    } else {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No parameter was inserted.");
    }
  }

  /**
  * Creates a new personal customer.
  *
  * @param customer PersonalCustomer object to be created.
  * @param result BindingResult for validating the request.
  * @return ResponseEntity with the created PersonalCustomer.
  * @throws ResponseStatusException if there are validation errors.
  */
  @PostMapping("/personal")
  public ResponseEntity<Customer> createPersonal(@Valid @RequestBody PersonalCustomer customer,
                                                 BindingResult result) {
    if (result.hasErrors()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
    }
    PersonalCustomer customerCreate = customerService.createPersonalCustomer(customer);
    return ResponseEntity.status(HttpStatus.CREATED).body(customerCreate);
  }

  /**
  * Creates a new business customer.
  *
  * @param customer BusinessCustomer object to be created.
  * @param result BindingResult for validating the request.
  * @return ResponseEntity with the created BusinessCustomer.
  * @throws ResponseStatusException if there are validation errors.
  */
  @PostMapping("/business")
  public ResponseEntity<Customer> createBusiness(@Valid @RequestBody BusinessCustomer customer,
                                                 BindingResult result) {
    if (result.hasErrors()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
    }
    BusinessCustomer customerCreate = customerService.createBusinessCustomer(customer);
    return ResponseEntity.status(HttpStatus.CREATED).body(customerCreate);
  }

  /**
  * Updates an existing customer.
  *
  * @param id ID of the customer to be updated.
  * @param updatedCustomer CustomerDto containing updated information.
  * @param result BindingResult for validating the request.
  * @return ResponseEntity with the updated Customer.
  * @throws ResponseStatusException if there are validation errors or the customer is not found.
  */
  @PutMapping(value = "/{id}")
  public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Long id,
                                                 @Valid @RequestBody CustomerDto updatedCustomer,
                                                 BindingResult result) {
    if (result.hasErrors()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
    }
    Customer updated = customerService.updateCustomer(id, updatedCustomer);
    if (updated != null) {
      return ResponseEntity.ok(updated);
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found.");
    }
  }

  /**
  * Deletes a customer based on their ID.
  *
  * @param id ID of the customer to be deleted.
  * @return ResponseEntity with the deleted Customer or a not found status.
  */
  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Long id) {
    Customer customer = customerService.deleteCustomer(id);
    if (Optional.ofNullable(customer).isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(customer);
  }

}
