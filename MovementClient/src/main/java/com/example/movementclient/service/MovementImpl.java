package com.example.movementclient.service;

import com.example.movementclient.domain.model.Movement;
import com.example.movementclient.domain.repository.MovementRepository;
import com.example.movementclient.domain.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovementImpl implements MovementService {
    @Autowired
    private MovementRepository movementRepository;
    @Override
    public Movement save(Movement movement) {
        return movementRepository.save(movement);
    }
}
