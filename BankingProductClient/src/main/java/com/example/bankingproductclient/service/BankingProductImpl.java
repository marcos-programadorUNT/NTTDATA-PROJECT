package com.example.bankingproductclient.service;

import com.example.bankingproductclient.domain.model.BankingProduct;
import com.example.bankingproductclient.domain.repository.BankingProductRepository;
import com.example.bankingproductclient.domain.service.BankingProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BankingProductImpl implements BankingProductService {

    @Autowired
    private BankingProductRepository bankingProductRepository;
    @Override
    public Optional<BankingProduct> findById(Integer id) {
        return bankingProductRepository.findById(id);
    }

    @Override
    public List<BankingProduct> findAll() {
        return bankingProductRepository.findAll();
    }

    @Override
    public BankingProduct createProduct(BankingProduct bankingProduct) {
        bankingProduct.setStatus("CREATED");
        bankingProduct.setRegistrationDate(new Date());
        return bankingProductRepository.save(bankingProduct);
    }

}
