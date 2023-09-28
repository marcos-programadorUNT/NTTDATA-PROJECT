package com.ntt.bankProduct.repository;
import com.ntt.bankProduct.entity.BankProduct;
import com.ntt.bankProduct.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface bankProductRepository extends JpaRepository<BankProduct, Long> {

    public List<BankProduct> findByCustomer(Customer customer);
    public List<BankProduct> findById(int id);

}
