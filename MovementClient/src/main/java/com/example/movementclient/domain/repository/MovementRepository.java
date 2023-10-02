package com.example.movementclient.domain.repository;

import com.example.movementclient.domain.model.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovementRepository extends JpaRepository<Movement,Integer> {
    @Query("SELECT m FROM Movement m WHERE m.bankingProduct.customer.id=?1")
    public List<Movement> movementsFindByCustomerId(Long customer_id);
}
