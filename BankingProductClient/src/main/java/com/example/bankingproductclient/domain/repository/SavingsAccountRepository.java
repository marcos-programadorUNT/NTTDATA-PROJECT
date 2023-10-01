package com.example.bankingproductclient.domain.repository;

import com.example.bankingproductclient.domain.model.BankingProduct;
import com.example.bankingproductclient.domain.model.SavingsAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SavingsAccountRepository extends JpaRepository<SavingsAccount,Integer> {
    /*
    @Query("SELECT s FROM SavingsAccount s WHERE s.passiveBankingProductType = 'savings_account'")
    public List<SavingsAccount> findAllSavingsAccount();

     */

}
