package com.example.bankingproductclient.service;

import com.example.bankingproductclient.domain.model.BankingProduct;
import com.example.bankingproductclient.domain.model.CurrentAccount;
import com.example.bankingproductclient.domain.repository.CurrentAccountRepository;
import com.example.bankingproductclient.domain.service.CurrentAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrentAccountServiceImpl implements CurrentAccountService {

    @Autowired
    private CurrentAccountRepository currentAccountRepository;

    @Override
    public CurrentAccount findById(Integer id) {
        return currentAccountRepository.findById(id).orElse(null);
    }

    @Override
    public List<CurrentAccount> findAll() {
        return currentAccountRepository.findAll();
    }

    @Override
    public CurrentAccount createCurrentAccount(CurrentAccount bankingProduct) {
        bankingProduct.setStatus("ACTIVE");
        bankingProduct.setRegistrationDate(new Date());
        return currentAccountRepository.save(bankingProduct);
    }
}
