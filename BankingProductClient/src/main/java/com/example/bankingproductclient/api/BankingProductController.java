package com.example.bankingproductclient.api;

import com.example.bankingproductclient.domain.model.BankingProduct;
import com.example.bankingproductclient.domain.model.Customer;
import com.example.bankingproductclient.domain.model.FixedTermAccount;
import com.example.bankingproductclient.domain.model.SavingsAccount;
import com.example.bankingproductclient.domain.service.BankingProductService;
import com.example.bankingproductclient.domain.service.FixedTermAccountService;
import com.example.bankingproductclient.domain.service.SavingsAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/bankingProducts")
public class BankingProductController {
    @Autowired
    private BankingProductService bankingProductService;
    @Autowired
    private SavingsAccountService savingsAccountService;
    @Autowired
    private FixedTermAccountService fixedTermAccountService;

    @GetMapping("/list")
    public List<SavingsAccount> findAll() {
        return  savingsAccountService.findAll();
    }


    @GetMapping("/")
    public String hello(){
        return "HELLO PIMIN";
    }

    @GetMapping(value = "/bankingProductEvaluate/{banking_product_id}")
    public ResponseEntity<Map<String, Object>> bankingProductEvaluate(@PathVariable(name="banking_product_id", required=false) Integer banking_product_id) {
        BankingProduct bankingProduct=bankingProductService.findById(banking_product_id);
        Map<String, Object> responseMethod = new HashMap<>();
        String httpStatusValue="CREATED", status=null, message=null;
        List<Object> data =new ArrayList<>();
        if(!bankingProduct.equals(null))
        {
            if(Objects.equals(bankingProduct.getBankingProductType().toString(), "savings_account"))
            {
                Long movementsCount= (long) bankingProduct.getMovements().size();
                SavingsAccount savingsAccount =savingsAccountService.findById(banking_product_id);
                if(savingsAccount.getMonthlyMovementLimit()>movementsCount)
                {

                    status="success";
                    message="The process was continued.";
                    httpStatusValue="OK";
                    data.add(bankingProduct.getCustomer());
                }
                else
                {
                    status="error";
                    message="The process cannot continue.";
                    httpStatusValue="BAD_REQUEST";
                }
            }
            else
            {
                if (Objects.equals(bankingProduct.getBankingProductType().toString(), "fixed_term_account"))
                {
                    FixedTermAccount fixedTermAccount = fixedTermAccountService.findById(banking_product_id);
                    LocalDate fechaActual = LocalDate.now();
                    byte diaActual = (byte) fechaActual.getDayOfMonth();

                    if (Objects.equals(fixedTermAccount.getSpecificDayMovement(), diaActual)) {
                        status="success";
                        message="The process was continued.";
                        httpStatusValue="OK";
                        data.add(bankingProduct.getCustomer());
                    }
                    else{
                        status="error";
                        message="The process cannot continue.";
                        httpStatusValue="BAD_REQUEST";

                    }
                }
                else
                {
                    status="error";
                    message="The process cannot continue.";
                    httpStatusValue="BAD_REQUEST";

                }
            }
        }
        responseMethod.put("status",status);
        responseMethod.put("message",message);
        responseMethod.put("data",data);
        return ResponseEntity.status(HttpStatus.valueOf(httpStatusValue)).body(responseMethod);
    }

    @GetMapping(value = "/findBankingProductById/{banking_product_id}")
    public BankingProduct findBankingProductById(@PathVariable(name="banking_product_id", required=false) Integer banking_product_id)
    {
        return bankingProductService.findById(banking_product_id);
    }

    @PutMapping("/updateBankingProduct")
    public BankingProduct updateBankingProduct(BankingProduct bankingProduct)
    {
        return bankingProductService.updateBankingProduct(bankingProduct);
    }



}
