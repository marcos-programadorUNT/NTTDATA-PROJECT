package com.example.bankingproductclient.service;

import com.example.bankingproductclient.domain.model.BankingProduct;
import com.example.bankingproductclient.domain.model.Customer;
import com.example.bankingproductclient.domain.repository.BankingProductRepository;
import com.example.bankingproductclient.domain.repository.CustomerRepository;
import com.example.bankingproductclient.domain.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Customer findById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
