package com.ntt.customerService.customer.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ntt.customerService.customer.domain.dto.CustomerDto;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("api/customers")
public class CustomerController {
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

    private final CustomerService customerService;

    @GetMapping
    public List<Customer> fetchAll(){
        return customerService.getAll();
    }

    @GetMapping(value = "/{type}")
    public List<Customer> getCustomersByType(@PathVariable("type") String type) {
        return customerService.getCustomersByType(type);
    }

    @PostMapping("/personal")
    public ResponseEntity<Customer> createPersonal(@Valid @RequestBody PersonalCustomer customer, BindingResult result){
        if(result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        PersonalCustomer customerCreate = customerService.createPersonalCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerCreate);
    }
    @PostMapping("/business")
    public ResponseEntity<Customer> createBusiness(@Valid @RequestBody BusinessCustomer customer, BindingResult result){
        if(result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        BusinessCustomer customerCreate = customerService.createBusinessCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerCreate);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Long id, @Valid @RequestBody CustomerDto updatedCustomer, BindingResult result){
        if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        Customer updated = customerService.updateCustomer(id, updatedCustomer);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found.");
        }
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Long id){
        Customer customer = customerService.deleteCustomer(id);
        if (Optional.ofNullable(customer).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customer);
    }

}
