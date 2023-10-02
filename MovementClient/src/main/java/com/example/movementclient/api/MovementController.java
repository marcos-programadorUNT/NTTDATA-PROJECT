package com.example.movementclient.api;

import com.example.movementclient.domain.model.BankingProduct;
import com.example.movementclient.domain.model.Movement;
import com.example.movementclient.domain.service.BankingProductService;
import com.example.movementclient.domain.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/movements")
public class MovementController {
    @Autowired
    private BankingProductService bankingProductService;
    @Autowired
    private MovementService movementService;

    @GetMapping("/{banking_product_id}")
    public ResponseEntity<Map<String, Object>> metBakingProduct(@PathVariable("banking_product_id") Integer banking_product_id)
    {
        return bankingProductService.bankingProductEvaluate(banking_product_id);
    }

    @GetMapping("/encontrar/{banking_product_id}")
    public Optional<BankingProduct> encontrarBankingProduct(@PathVariable("banking_product_id") Integer banking_product_id)
    {
        return bankingProductService.findBankingProductById(banking_product_id);
    }


    @PostMapping(value="/saveMovement", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Movement saveMovement(@RequestBody Movement movement)
    {
        /*
        ResponseEntity<Map<String, Object>> evaluateBankingProduct=bankingProductService.bankingProductEvaluate(movement.getBankingProduct().getId());
        Map<String, Object> responseBody = evaluateBankingProduct.getBody();
        String httpStatusValue=null, status=null, message=null;
        List<Object> data =new ArrayList<>();
        Map<String, Object> responseMethod = new HashMap<>();
        if (responseBody != null && responseBody.containsKey("status")) {
            String statusBankingProduct = (String) responseBody.get("status");
            if ("success".equals(statusBankingProduct)) {
                    Optional<BankingProduct> bankingProductOptional=bankingProductService.findBankingProductById(movement.getBankingProduct().getId());
                    if (bankingProductOptional.isPresent())
                    {
                        movement.setBankingProduct(bankingProductOptional.get());
                        Movement movementSave=movementService.save(movement);

                        float newBalance=0;
                        switch (movement.getMovementType())
                        {
                            case "D":
                            case "P":
                            newBalance=bankingProductOptional.get().getBalance()+movement.getMoneyRequired();
                            break;
                            case "W":
                            newBalance=bankingProductOptional.get().getBalance()-movement.getMoneyRequired();
                            break;
                        }
                        bankingProductService.updateBankingProductByBalance(newBalance,bankingProductOptional.get().getId());

                        status="success";
                        message="Normal";
                        data.add(movement);
                        httpStatusValue="CREATED";
                    }
            } else {

            }
        } else {

        }

        responseMethod.put("status",status);
        responseMethod.put("message",message);
        responseMethod.put("data",data);
        return ResponseEntity.status(HttpStatus.valueOf(httpStatusValue)).body(responseMethod);
        */
        /*
        Optional<BankingProduct> bankingProductOptional=bankingProductService.findBankingProductById(movement.getBankingProduct().getId());
        if (bankingProductOptional.isPresent())
            movement.setBankingProduct(bankingProductOptional.get());
         */



        Optional<BankingProduct> bankingProductOptional=bankingProductService.findBankingProductById(movement.getBankingProduct().getId());
        if (bankingProductOptional.isPresent())
            movement.setBankingProduct(bankingProductOptional.get());


        //Movement movementSave=movementService.save(movement);
        return movementService.save(movement);
    }

    @PostMapping("/prueba")
    public String saveMovement(@RequestBody String cadena)
    {
        return cadena;
    }


}
