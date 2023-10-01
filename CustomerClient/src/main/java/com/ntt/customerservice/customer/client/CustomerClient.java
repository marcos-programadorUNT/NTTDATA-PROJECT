package com.ntt.customerservice.customer.client;

import com.ntt.customerservice.customer.domain.model.entity.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "customerservice", fallback = CustomerHystrixFallbackFactory.class)
public interface CustomerClient {
  @GetMapping("api/customers/search")
  public ResponseEntity<Customer> searchCustomer(
      @RequestParam(value = "documentNumber", required = false) String documentNumber,
      @RequestParam(value = "ruc", required = false) String ruc);
}
