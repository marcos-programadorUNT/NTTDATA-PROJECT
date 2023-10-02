package com.example.bankingproductclient.domain.service;
import com.example.bankingproductclient.domain.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    public Customer findById(Integer id);

    List<Customer> findAll();
}
