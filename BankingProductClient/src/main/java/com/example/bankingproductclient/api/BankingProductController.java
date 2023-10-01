package com.example.bankingproductclient.api;

import com.example.bankingproductclient.domain.model.BankingProduct;
import com.example.bankingproductclient.domain.model.SavingsAccount;
import com.example.bankingproductclient.domain.repository.BankingProductRepository;
import com.example.bankingproductclient.domain.service.BankingProductService;
import com.example.bankingproductclient.domain.service.SavingsAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/bankingProducts")
public class BankingProductController {
    @Autowired
    private BankingProductService bankingProductService;
    @Autowired
    private SavingsAccountService savingsAccountService;

    @GetMapping("/hello/{banking_product_id}")
    public Integer hello(@PathVariable(name="banking_product_id", required=false) Integer banking_product_id){
        return banking_product_id;
    }
    /*
    @GetMapping(value = "/bankingProductEvaluate/{banking_product_id}")
    public Optional<BankingProduct> bankingProductEvaluate(@PathVariable(name="banking_product_id", required=false) Integer banking_product_id) {
        Optional<BankingProduct> bankingProduct = null;
        try {
            bankingProduct = bankingProductService.findById(banking_product_id);
        } catch (Exception e) {
            // Captura la excepción y muestra el mensaje de error
            System.err.println("Se produjo una excepción: " + e.getMessage());
        }
        return bankingProduct;
    }
     */

    @GetMapping(value = "/bankingProductEvaluate/{banking_product_id}")
    public String bankingProductEvaluate(@PathVariable(name="banking_product_id", required=false) Integer banking_product_id) {
        Optional<BankingProduct> bankingProduct=bankingProductService.findById(banking_product_id);
        Optional<SavingsAccount> savingsAccount =savingsAccountService.findById(banking_product_id);
        if(!bankingProduct.isEmpty())
        {
            if(!savingsAccount.isEmpty() && Objects.equals(savingsAccount.get().getBankingProductType(), "savings_account"))
            {


            }
        }


        return  "PIMIN";
    }

    @GetMapping("/")
    public List<SavingsAccount> findAll() {
        return  savingsAccountService.findAll();
    }
}
