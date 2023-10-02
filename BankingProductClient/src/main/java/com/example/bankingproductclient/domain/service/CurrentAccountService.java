package com.example.bankingproductclient.domain.service;

import com.example.bankingproductclient.domain.model.BankingProduct;
import com.example.bankingproductclient.domain.model.CurrentAccount;
import com.example.bankingproductclient.domain.model.SavingsAccount;

import java.util.List;
import java.util.Optional;

public interface CurrentAccountService {
    /*
    public Optional<SavingsAccount> findById(Integer id);
    public List<SavingsAccount> findAll();
    public List<SavingsAccount> findAllSavingsAccount();

     */
    public List<CurrentAccount> findAll();
    public CurrentAccount findById(Integer id);

    CurrentAccount createCurrentAccount(CurrentAccount bankingProduct);
}
