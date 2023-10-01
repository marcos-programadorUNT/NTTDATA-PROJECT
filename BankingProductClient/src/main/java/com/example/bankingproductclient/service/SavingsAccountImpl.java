package com.example.bankingproductclient.service;

import com.example.bankingproductclient.domain.model.SavingsAccount;
import com.example.bankingproductclient.domain.repository.BankingProductRepository;
import com.example.bankingproductclient.domain.repository.SavingsAccountRepository;
import com.example.bankingproductclient.domain.service.BankingProductService;
import com.example.bankingproductclient.domain.service.SavingsAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SavingsAccountImpl implements SavingsAccountService {
    /*
    @Autowired
    private SavingsAccountRepository savingsAccountRepository;
    @Override
    public Optional<SavingsAccount> findById(Integer id) {
        return savingsAccountRepository.findById(id);
    }

    @Override
    public List<SavingsAccount> findAll() {
        return savingsAccountRepository.findAll();
    }

    @Override
    public List<SavingsAccount> findAllSavingsAccount() {
        return savingsAccountRepository.findAllSavingsAccount();
    }

     */
    @Autowired
    private SavingsAccountRepository savingsAccountRepository;
    @Override
    public List<SavingsAccount> findAll() {
        return savingsAccountRepository.findAll();
    }
    @Override
    public Optional<SavingsAccount> findById(Integer id) {
        return savingsAccountRepository.findById(id);
    }
}
