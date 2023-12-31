package com.example.movementclient.domain.service;

import com.example.movementclient.domain.model.BankingProduct;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Map;
import java.util.Optional;


public interface BankingProductService {
    public ResponseEntity<Map<String, Object>> bankingProductEvaluate(Integer banking_product_id);
    public BankingProduct findBankingProductById(Integer banking_product_id);
    public BankingProduct updateBankingProduct(BankingProduct bankingProduct);
}
