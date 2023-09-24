package com.ntt.customerService.customer.api;

import com.ntt.customerService.customer.domain.model.entity.BusinessCustomer;
import com.ntt.customerService.customer.domain.model.entity.Customer;
import com.ntt.customerService.customer.domain.model.entity.PersonalCustomer;
import com.ntt.customerService.customer.domain.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/customers")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public List<Customer> fetchAll(){
        return customerService.getAll();
    }

    @GetMapping("/type/{type}")
    public List<Customer> getCustomersByType(@PathVariable String type) {
        return customerService.getCustomersByType(type);
    }
    @PostMapping("/personal")
    public ResponseEntity<Customer> createPersonal(@Valid @RequestBody PersonalCustomer customer, BindingResult result){
        if(result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "this.formatMessage(result)");
        }
        PersonalCustomer customerCreate = customerService.createPersonalCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerCreate);
    }
    @PostMapping("/business")
    public ResponseEntity<Customer> createBusiness(@Valid @RequestBody BusinessCustomer customer, BindingResult result){
        if(result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "this.formatMessage(result)");
        }
        BusinessCustomer customerCreate = customerService.createBusinessCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerCreate);
    }
}
