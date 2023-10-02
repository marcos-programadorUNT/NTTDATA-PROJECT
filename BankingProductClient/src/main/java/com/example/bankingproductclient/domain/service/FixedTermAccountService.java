package com.example.bankingproductclient.domain.service;

import com.example.bankingproductclient.domain.model.FixedTermAccount;


import java.util.Optional;

public interface FixedTermAccountService {
    public FixedTermAccount findById(Integer id);
}
