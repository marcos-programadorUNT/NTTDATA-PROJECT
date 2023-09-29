package com.example.bankingproductclient.domain.repository;

import com.example.bankingproductclient.domain.model.BankingProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BankingProductRepository extends JpaRepository<BankingProduct,Integer>{
    public Optional<BankingProduct> findById(Integer id);
}
