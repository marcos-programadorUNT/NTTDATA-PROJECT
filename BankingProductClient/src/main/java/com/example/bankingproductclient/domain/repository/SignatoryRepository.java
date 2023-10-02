package com.example.bankingproductclient.domain.repository;

import com.example.bankingproductclient.domain.model.CurrentAccount;
import com.example.bankingproductclient.domain.model.Signatory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignatoryRepository extends JpaRepository<Signatory,Integer> {

}
