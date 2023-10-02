package com.example.bankingproductclient.domain.service;

import com.example.bankingproductclient.domain.model.BankingProduct;
import com.example.bankingproductclient.domain.model.CurrentAccount;
import com.example.bankingproductclient.domain.model.Signatory;

import java.util.List;

public interface SignatoryService {
    /*
    public Optional<SavingsAccount> findById(Integer id);
    public List<SavingsAccount> findAll();
    public List<SavingsAccount> findAllSavingsAccount();

     */
    public List<Signatory> findAll();
    public Signatory findById(Integer id);

    Signatory createSignatory(Signatory signatory);
}
