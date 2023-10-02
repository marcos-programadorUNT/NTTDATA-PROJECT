package com.example.movementclient.domain.repository;

import com.example.movementclient.domain.model.BankingProduct;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;
import java.util.Optional;

@FeignClient(name="bankingproductservice")
public interface BankingProductRepository {
    @GetMapping("/api/bankingProducts/bankingProductEvaluate/{banking_product_id}")
    public ResponseEntity<Map<String, Object>> bankingProductEvaluate(@PathVariable("banking_product_id") Integer banking_product_id);
    @GetMapping("/api/bankingProducts/findBankingProductById/{banking_product_id}")
    public Optional<BankingProduct> findBankingProductById(@PathVariable("banking_product_id") Integer banking_product_id);

    /*
    @GetMapping("/api/bankingProducts/updateBankingProductByBalance")
    public Optional<BankingProduct> updateBankingProductByBalance(Float balance, Integer banking_product_id);

     */
}
