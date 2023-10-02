package com.example.bankingproductclient.domain.repository;

import com.example.bankingproductclient.domain.model.BankingProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface BankingProductRepository extends JpaRepository<BankingProduct,Integer>{
    /*
    public Optional<BankingProduct> findById(Integer id);
     */

    @Query("UPDATE BankingProduct  b SET b.balance=?1 WHERE b.id=?2")
    public Optional<BankingProduct> updateBankingProductByBalance(float balance, Integer banking_product_id);
}
