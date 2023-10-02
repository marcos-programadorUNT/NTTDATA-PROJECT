package com.example.bankingproductclient.domain.repository;

import com.example.bankingproductclient.domain.model.BankingProduct;
import com.example.bankingproductclient.domain.model.FixedTermAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FixedTermAccountRepository extends JpaRepository<FixedTermAccount,Integer> {
}
