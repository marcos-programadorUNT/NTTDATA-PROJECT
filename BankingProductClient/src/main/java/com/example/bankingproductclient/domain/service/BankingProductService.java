package com.example.bankingproductclient.domain.service;

import com.example.bankingproductclient.domain.model.BankingProduct;

import java.util.List;
import java.util.Optional;

public interface BankingProductService {

    public BankingProduct findById(Integer id);

    List<BankingProduct> findAll();

    BankingProduct createProduct(BankingProduct bankingProduct);
}
