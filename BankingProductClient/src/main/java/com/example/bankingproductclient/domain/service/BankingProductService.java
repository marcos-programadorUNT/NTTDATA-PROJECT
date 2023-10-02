package com.example.bankingproductclient.domain.service;

import com.example.bankingproductclient.domain.model.BankingProduct;

import java.util.Optional;

public interface BankingProductService {

    public Optional<BankingProduct> findById(Integer id);
    public Optional<BankingProduct> updateBankingProductByBalance(float balance, Integer banking_product_id);



}
