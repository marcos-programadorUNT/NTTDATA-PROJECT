package com.ntt.customerservice.customer.client;

import com.ntt.customerservice.customer.domain.model.entity.Customer;
import com.ntt.customerservice.customer.domain.model.entity.CustomerType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerHystrixFallbackFactory implements CustomerClient {

  @Override
  public ResponseEntity<Customer> searchCustomer(String documentNumber, String ruc) {
    Customer customer = Customer.builder()
        .email("none")
        .address("none")
        .phoneNumber("none")
        .customerType(CustomerType.valueOf("none")).build();

    return ResponseEntity.ok(customer);
  }
}
