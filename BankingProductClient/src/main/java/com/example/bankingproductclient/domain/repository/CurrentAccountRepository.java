package com.example.bankingproductclient.domain.repository;

import com.example.bankingproductclient.domain.model.CurrentAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentAccountRepository extends JpaRepository<CurrentAccount,Integer> {

}
