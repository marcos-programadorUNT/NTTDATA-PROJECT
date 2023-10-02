package com.example.bankingproductclient.domain.service;
import com.example.bankingproductclient.domain.model.Bank;
import com.example.bankingproductclient.domain.model.Customer;

import java.util.List;

public interface BankService {

    public Bank findById(Integer id);

    List<Bank> findAll();
}
