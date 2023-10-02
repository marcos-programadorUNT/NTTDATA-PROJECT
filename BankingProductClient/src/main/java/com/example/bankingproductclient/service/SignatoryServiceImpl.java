package com.example.bankingproductclient.service;

import com.example.bankingproductclient.domain.model.BankingProduct;
import com.example.bankingproductclient.domain.model.CurrentAccount;
import com.example.bankingproductclient.domain.model.Signatory;
import com.example.bankingproductclient.domain.repository.CurrentAccountRepository;
import com.example.bankingproductclient.domain.repository.SignatoryRepository;
import com.example.bankingproductclient.domain.service.CurrentAccountService;
import com.example.bankingproductclient.domain.service.SignatoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SignatoryServiceImpl implements SignatoryService {

    @Autowired
    private SignatoryRepository signatoryRepository;

    @Override
    public Signatory findById(Integer id) {
        return signatoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Signatory> findAll() {
        return signatoryRepository.findAll();
    }

    @Override
    public Signatory createSignatory(Signatory signatory) {
        signatory.setStatus("ACTIVE");
        return signatoryRepository.save(signatory);
    }
}
