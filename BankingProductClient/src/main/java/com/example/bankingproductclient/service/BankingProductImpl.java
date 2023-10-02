package com.example.bankingproductclient.service;

import com.example.bankingproductclient.domain.model.BankingProduct;
import com.example.bankingproductclient.domain.repository.BankingProductRepository;
import com.example.bankingproductclient.domain.service.BankingProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankingProductImpl implements BankingProductService {

    @Autowired
    private BankingProductRepository bankingProductRepository;
    @Override
    public BankingProduct findById(Integer id) {

        return bankingProductRepository.findById(id).orElse(null);
    }

    @Override
    public BankingProduct updateBankingProduct(BankingProduct bankingProduct) {
        return bankingProductRepository.updateBankingProduct(bankingProduct);
    }


}
