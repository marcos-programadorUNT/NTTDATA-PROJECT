package com.example.bankingproductclient.domain.repository;

import com.example.bankingproductclient.domain.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank,Integer> {

}
