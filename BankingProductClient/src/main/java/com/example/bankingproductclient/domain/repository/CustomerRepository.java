package com.example.bankingproductclient.domain.repository;

import com.example.bankingproductclient.domain.model.Customer;
import com.example.bankingproductclient.domain.model.SavingsAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

}
