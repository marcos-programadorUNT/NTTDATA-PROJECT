package com.example.bankingproductclient.service;

import com.example.bankingproductclient.domain.model.Bank;
import com.example.bankingproductclient.domain.repository.BankRepository;
import com.example.bankingproductclient.domain.service.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BankServiceImpl implements BankService {

    @Autowired
    private BankRepository bankRepository;
    @Override
    public Bank findById(Integer id) {
        return bankRepository.findById(id).orElse(null);
    }

    @Override
    public List<Bank> findAll() {
        return bankRepository.findAll();
    }
}
