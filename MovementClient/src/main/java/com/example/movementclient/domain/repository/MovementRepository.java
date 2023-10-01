package com.example.movementclient.domain.repository;

import com.example.movementclient.domain.model.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementRepository extends JpaRepository<Movement,Integer> {

}
