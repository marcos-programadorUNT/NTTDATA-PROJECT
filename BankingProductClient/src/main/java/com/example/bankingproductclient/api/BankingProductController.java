package com.example.bankingproductclient.api;

import com.example.bankingproductclient.domain.model.*;
import com.example.bankingproductclient.domain.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/api/bankingProducts")
public class BankingProductController {

    @Autowired
    private BankingProductService bankingProductService;
    @Autowired
    private SavingsAccountService savingsAccountService;
    @Autowired
    private CurrentAccountService currentAccountService;

    @Autowired
    private SignatoryService signatoryService;
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
        Customer customer = customerService.findById(customerId);

        if (customer == null){
            return ResponseEntity.notFound().build();
        }

        List <BankingProduct> bankingProducts = customer.getBankingProducts();

        return ResponseEntity.ok(bankingProducts);
    }

    @PostMapping("/customer/{customerId}/addBankingProduct/personalCredit")
    public ResponseEntity<BankingProduct> addBankingProductPersonalCredit(
            @Valid
            @PathVariable Integer customerId,
            @RequestBody PersonalCredit bankingProduct
    ) {
        Customer customer = customerService.findById(customerId);
        Bank bank = bankService.findById(1);

        if (customer == null) {
            return ResponseEntity.notFound().build();
        }

        List<Movement> movements = Collections.emptyList();
        bankingProduct.setCustomer(customer);
        bankingProduct.setBank(bank);
        bankingProduct.setBankingProductType(BankingProductType.personal_credit);
        bankingProduct.setMovements(movements);
        BankingProduct savedBankingProduct = bankingProductService.createProduct(bankingProduct);

        return ResponseEntity.ok(savedBankingProduct);
    }

    @PostMapping("/customer/{customerId}/addBankingProduct/businessCredit")
    public ResponseEntity<BankingProduct> addBankingProductPersonalBusinessCredit(
            @Valid
            @PathVariable Integer customerId,
            @RequestBody BusinessCredit bankingProduct
    ) {
        Customer customer = customerService.findById(customerId);
        Bank bank = bankService.findById(1);

        if (customer == null) {
            return ResponseEntity.notFound().build();
        }

        List<Movement> movements = Collections.emptyList();
        bankingProduct.setCustomer(customer);
        bankingProduct.setBank(bank);
        bankingProduct.setBankingProductType(BankingProductType.business_credit);
        bankingProduct.setMovements(movements);
        BankingProduct savedBankingProduct = bankingProductService.createProduct(bankingProduct);

        return ResponseEntity.ok(savedBankingProduct);
    }

    @PostMapping("/customer/{customerId}/addBankingProduct/creditCard")
    public ResponseEntity<BankingProduct> addBankingProductPersonalCreditCard(
            @Valid
            @PathVariable Integer customerId,
            @RequestBody CreditCard bankingProduct
    ) {
        Customer customer = customerService.findById(customerId);
        Bank bank = bankService.findById(1);

        if (customer == null) {
            return ResponseEntity.notFound().build();
        }

        List<Movement> movements = Collections.emptyList();
        bankingProduct.setCustomer(customer);
        bankingProduct.setBank(bank);
        bankingProduct.setBankingProductType(BankingProductType.credit_card);
        bankingProduct.setMovements(movements);
        BankingProduct savedBankingProduct = bankingProductService.createProduct(bankingProduct);

        return ResponseEntity.ok(savedBankingProduct);
    }

    @PostMapping("/customer/{customerId}/addBankingProduct/currentAccount")
    public ResponseEntity<BankingProduct> addBankingProductPersonalCurrentAccount(
            @Valid
            @PathVariable Integer customerId,
            @RequestBody CurrentAccount bankingProduct
    ) {
        Customer customer = customerService.findById(customerId);
        Bank bank = bankService.findById(1);

        if (customer == null) {
            return ResponseEntity.notFound().build();
        }

        List<Movement> movements = Collections.emptyList();
        bankingProduct.setCustomer(customer);
        bankingProduct.setBank(bank);
        bankingProduct.setBankingProductType(BankingProductType.current_account);
        bankingProduct.setMovements(movements);
        BankingProduct savedBankingProduct = bankingProductService.createProduct(bankingProduct);

        return ResponseEntity.ok(savedBankingProduct);
    }

    @PostMapping("/customer/{customerId}/addBankingProduct/savingAccount")
    public ResponseEntity<BankingProduct> addBankingProductSavingAccount(
            @Valid
            @PathVariable Integer customerId,
            @RequestBody SavingsAccount bankingProduct
    ) {
        Customer customer = customerService.findById(customerId);
        Bank bank = bankService.findById(1);

        if (customer == null) {
            return ResponseEntity.notFound().build();
        }

        List<Movement> movements = Collections.emptyList();
        bankingProduct.setCustomer(customer);
        bankingProduct.setBank(bank);
        bankingProduct.setBankingProductType(BankingProductType.savings_account);
        bankingProduct.setMovements(movements);
        BankingProduct savedBankingProduct = bankingProductService.createProduct(bankingProduct);

        return ResponseEntity.ok(savedBankingProduct);
    }

    @PostMapping("/customer/{customerId}/addBankingProduct/fixedTermAccount")
    public ResponseEntity<BankingProduct> addBankingProductFixedTermAccount(
            @Valid
            @PathVariable Integer customerId,
            @RequestBody FixedTermAccount bankingProduct
    ) {
        Customer customer = customerService.findById(customerId);

        Bank bank = bankService.findById(1);

        if (customer == null) {
            return ResponseEntity.notFound().build();
        }

        List<Movement> movements = Collections.emptyList();
        bankingProduct.setCustomer(customer);
        bankingProduct.setBank(bank);
        bankingProduct.setBankingProductType(BankingProductType.fixed_term_account);
        bankingProduct.setMovements(movements);
        BankingProduct savedBankingProduct = bankingProductService.createProduct(bankingProduct);

        return ResponseEntity.ok(savedBankingProduct);
    }

    @PostMapping("/customer/addSignatory/{bankProductId}/{customerId}")
    public ResponseEntity<CurrentAccount> addBankingProductHolder(
            @Valid
            @PathVariable Integer bankProductId,
            @PathVariable Integer customerId,
            @RequestBody Signatory signatory
    ) {

        CurrentAccount bankingProduct = currentAccountService.findById(bankProductId);
        Customer customer = customerService.findById(customerId);

        if (bankingProduct == null || customerId == null) {
            return ResponseEntity.notFound().build();
        }

        signatory.setCustomer(customer);
        signatory.setCurrentAccount(bankingProduct);

        Signatory savedSignatory = signatoryService.createSignatory(signatory);

        return ResponseEntity.ok(bankingProduct);
    }

    @PostMapping("/customer/addHolder/{bankProductId}/{customerId}")
    public ResponseEntity<CurrentAccount> addBankingProductCustomer(
            @Valid
            @PathVariable Integer bankProductId,
            @PathVariable Integer customerId
    ) {

        CurrentAccount bankingProduct = currentAccountService.findById(bankProductId);
        Customer customer = customerService.findById(customerId);

        if (bankingProduct == null || customerId == null ) {
            return ResponseEntity.notFound().build();
        }

        List<Customer> clients = bankingProduct.getAccountsHolder();
        clients.add(customer);
        bankingProduct.setAccountsHolder(clients);
        //bankingProduct.setCurrentAccount(bankingProduct);

        CurrentAccount savedCurrentAccount = currentAccountService.createCurrentAccount(bankingProduct);

        return ResponseEntity.ok(savedCurrentAccount);
    }

    /*
    @PostMapping("/customer/{customerId}/addBankingProduct")
    public ResponseEntity<BankingProduct> addBankingProductToCustomer(
            @PathVariable Integer customerId,
            @RequestBody Map<String, Object> requestBody
    ) {
        Customer customer = customerService.findById(customerId);

        if (customer == null) {
            return ResponseEntity.notFound().build();
        }

        // Extrae el tipo de producto bancario del cuerpo de la solicitud
        String bankingProductType = (String) requestBody.get("bankingProductType");

        // Crea una instancia del tipo de producto bancario correspondiente
        BankingProduct newBankingProduct = null;

        if (BankingProductType.active_banking_product.toString().equals(bankingProductType)) {
            // Aquí debes crear una instancia de ActiveBankingProduct
            // newBankingProduct = new ActiveBankingProduct();
        } else if (BankingProductType.passive_banking_product.toString().equals(bankingProductType)) {
            // Aquí debes crear una instancia de PassiveBankingProduct
            // newBankingProduct = new PassiveBankingProduct();
        } else if (BankingProductType.savings_account.toString().equals(bankingProductType)) {
            // Aquí debes crear una instancia de SavingsAccount
            // newBankingProduct = new SavingsAccount();
        } else if (BankingProductType.fixed_term_account.toString().equals(bankingProductType)) {
            // Aquí debes crear una instancia de FixedTermAccount
            // newBankingProduct = new FixedTermAccount();
        } else if (BankingProductType.current_account.toString().equals(bankingProductType)) {
            // Aquí debes crear una instancia de CurrentAccount
            newBankingProduct = new CurrentAccount();
        }

        if (newBankingProduct == null) {
            return ResponseEntity.badRequest().build();
        }

        // Ahora, puedes establecer otros atributos del producto bancario según sea necesario
        // Por ejemplo, si maintenanceCommissionAmount es parte de CurrentAccount
        if (newBankingProduct instanceof CurrentAccount) {
            Float maintenanceCommissionAmount = Float.parseFloat(requestBody.get("maintenanceCommissionAmount").toString());
            ((CurrentAccount) newBankingProduct).setMaintenanceCommissionAmount(maintenanceCommissionAmount != null ? maintenanceCommissionAmount : 0.0f);
        }

        newBankingProduct.setCustomer(customer);
        newBankingProduct.setBank(bankService.findById(1));
        newBankingProduct.setBankingProductType(BankingProductType.valueOf(bankingProductType));
        newBankingProduct.setMovements(Collections.emptyList());
        newBankingProduct.setStatus("ACTIVE");
        newBankingProduct.setRegistrationDate(new Date());

        // Finalmente, guarda el producto bancario
        BankingProduct savedBankingProduct = bankingProductService.createProduct(newBankingProduct);

        return ResponseEntity.ok(savedBankingProduct);
    }

     */

}
