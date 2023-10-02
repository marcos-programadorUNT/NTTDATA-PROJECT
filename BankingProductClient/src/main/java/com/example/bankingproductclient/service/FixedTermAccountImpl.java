package com.example.bankingproductclient.service;

import com.example.bankingproductclient.domain.model.FixedTermAccount;
import com.example.bankingproductclient.domain.model.SavingsAccount;
import com.example.bankingproductclient.domain.repository.FixedTermAccountRepository;
import com.example.bankingproductclient.domain.repository.SavingsAccountRepository;
import com.example.bankingproductclient.domain.service.FixedTermAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FixedTermAccountImpl implements FixedTermAccountService {
    @Autowired
    private FixedTermAccountRepository fixedTermAccountRepository;
    @Override
    public Optional<FixedTermAccount> findById(Integer id) {
        return fixedTermAccountRepository.findById(id);
    }
}
