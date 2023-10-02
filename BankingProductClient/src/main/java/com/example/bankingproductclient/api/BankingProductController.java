package com.example.bankingproductclient.api;

import com.example.bankingproductclient.domain.model.*;
import com.example.bankingproductclient.domain.service.BankService;
import com.example.bankingproductclient.domain.service.BankingProductService;
import com.example.bankingproductclient.domain.service.CustomerService;
import com.example.bankingproductclient.domain.service.SavingsAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bankingProducts")
public class BankingProductController {

    @Autowired
    private BankingProductService bankingProductService;
    @Autowired
    private SavingsAccountService savingsAccountService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private BankService bankService;

    @GetMapping("/")
    public List<BankingProduct> findAll() {
        return  bankingProductService.findAll();
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<BankingProduct>> findBankingProductsByCustomerId(@PathVariable Integer customerId) {
        // Primero, busca al cliente por su ID
        Customer customer = customerService.findById(customerId);

        if (customer == null){
            return ResponseEntity.notFound().build();
        }

        List <BankingProduct> bankingProducts = customer.getBankingProducts();

        return ResponseEntity.ok(bankingProducts);
    }

    @PostMapping("/customer/{customerId}/addBankingProduct")
    public ResponseEntity<BankingProduct> addBankingProductToCustomer(
            @Valid
            @PathVariable Integer customerId,
            @RequestBody BankingProduct bankingProduct
    ) {
        Customer customer = customerService.findById(customerId);
        Bank bank = bankService.findById(1);

        if (customer == null) {
            return ResponseEntity.notFound().build();
        }
        List<Movement> movements = Collections.emptyList();
        bankingProduct.setCustomer(customer);
        bankingProduct.setBank(bank);
        bankingProduct.setMovements(movements);
        BankingProduct savedBankingProduct = bankingProductService.createProduct(bankingProduct);

        return ResponseEntity.ok(savedBankingProduct);
    }

}
