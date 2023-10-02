package com.example.movementclient.api;

import com.example.movementclient.domain.model.BankingProduct;
import com.example.movementclient.domain.model.Movement;
import com.example.movementclient.domain.service.BankingProductService;
import com.example.movementclient.domain.service.MovementService;
import org.hibernate.exception.ConstraintViolationException;
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
    public BankingProduct encontrarBankingProduct(@PathVariable("banking_product_id") Integer banking_product_id)
    {
        return bankingProductService.findBankingProductById(banking_product_id);
    }


    @PostMapping(value="/saveMovement", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)

    // public ResponseEntity<Map<String, Object>>
    public ResponseEntity<Map<String, Object>> saveMovement(@RequestBody Movement movement)
    {
        ResponseEntity<Map<String, Object>> evaluateBankingProduct=bankingProductService.bankingProductEvaluate(movement.getBankingProduct().getId());
        Map<String, Object> responseBody = evaluateBankingProduct.getBody();
        String httpStatusValue=null, status=null, message=null;
        List<Object> data =new ArrayList<>();
        Map<String, Object> responseMethod = new HashMap<>();
        if (responseBody != null && responseBody.containsKey("status")) {
            String statusBankingProduct = (String) responseBody.get("status");
            if ("success".equals(statusBankingProduct)) {
                    BankingProduct bankingProduct=bankingProductService.findBankingProductById(movement.getBankingProduct().getId());
                    if (bankingProduct!=null)
                    {
                        float newBalance=0;
                        switch (movement.getMovementType())
                        {
                            case "D":
                            case "P":
                            newBalance=bankingProduct.getBalance()+movement.getMoneyRequired();
                            break;
                            case "W":
                            newBalance=bankingProduct.getBalance()-movement.getMoneyRequired();
                            break;
                            default:
                            newBalance=bankingProduct.getBalance();
                            break;
                        }
                        bankingProduct.setBalance(newBalance);
                        movement.setBankingProduct(bankingProduct);
                        Movement movementSave=movementService.save(movement);
                        status="success";
                        message="Movement was saved successfully";
                        data.add(movementSave);
                        httpStatusValue="CREATED";
                    }
            } else {

                status="error";
                message="Movement was not saved successfully.";
                httpStatusValue="BAD_REQUEST";
            }
        } else {
            status="error";
            message="Movement was not saved successfully.";
            httpStatusValue="BAD_REQUEST";
        }

        responseMethod.put("status",status);
        responseMethod.put("message",message);
        responseMethod.put("data",data);
        return ResponseEntity.status(HttpStatus.valueOf(httpStatusValue)).body(responseMethod);
    }

    @PostMapping("/prueba")
    public String saveMovement(@RequestBody String cadena)
    {
        return cadena;
    }




     /*
        try {
            BankingProduct bankingProduct=bankingProductService.findBankingProductById(movement.getBankingProduct().getId());
            Movement movement1= new Movement();
            movement1.setMovementType(movement.getMovementType());
            movement1.setBankingProduct(bankingProduct);
            movement1.setStatus(movement.getStatus());
            movement1.setMoneyRequired(movement.getMoneyRequired());
            movement1.setRegistrationDate(movement.getRegistrationDate());
            Movement savedMovement = movementService.save(movement1);
            return new ResponseEntity<>(savedMovement, HttpStatus.CREATED);
        } catch (ConstraintViolationException e) {
            // Aquí puedes obtener el mensaje de error de la excepción y enviarlo al cliente
            String errorMessage = e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }
         */

}
