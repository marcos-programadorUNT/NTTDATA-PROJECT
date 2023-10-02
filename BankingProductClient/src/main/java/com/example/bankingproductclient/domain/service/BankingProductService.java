package com.example.bankingproductclient.domain.service;

import com.example.bankingproductclient.domain.model.BankingProduct;

import java.util.Optional;

public interface BankingProductService {

    public BankingProduct findById(Integer id);
    public BankingProduct updateBankingProduct(BankingProduct bankingProduct);



}
