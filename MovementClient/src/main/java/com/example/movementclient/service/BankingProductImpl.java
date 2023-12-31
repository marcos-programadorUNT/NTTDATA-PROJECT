package com.example.movementclient.service;

import com.example.movementclient.domain.model.BankingProduct;
import com.example.movementclient.domain.repository.BankingProductRepository;
import com.example.movementclient.domain.service.BankingProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;
import java.util.Optional;

@Service
public class BankingProductImpl implements BankingProductService {
    @Autowired
    private BankingProductRepository bankingProductRepository;
    public ResponseEntity<Map<String, Object>> bankingProductEvaluate(@PathVariable("banking_product_id") Integer banking_product_id)
    {
        return bankingProductRepository.bankingProductEvaluate(banking_product_id);

    }
    @Override
    public BankingProduct findBankingProductById(Integer banking_product_id) {
        return bankingProductRepository.findBankingProductById(banking_product_id);
    }
    @Override
    public BankingProduct updateBankingProduct(BankingProduct bankingProduct) {
        return bankingProductRepository.updateBankingProduct(bankingProduct);
    }
}
