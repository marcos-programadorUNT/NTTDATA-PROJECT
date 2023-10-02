package com.example.movementclient.domain.service;

import com.example.movementclient.domain.model.Movement;
import com.example.movementclient.service.MovementImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Service
public interface MovementService  {

    public Movement save(Movement movement);
    public List<Movement> movementsFindByCustomerId(Long customer_id);

}
