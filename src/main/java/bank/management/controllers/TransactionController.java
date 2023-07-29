package bank.management.controllers;

import bank.management.models.dtos.AccountDto;
import bank.management.models.dtos.CustomerDto;
import bank.management.models.dtos.TransactionRequestDto;
import bank.management.models.entities.Account;
import bank.management.models.entities.Customer;
import bank.management.models.entities.TransactionEntity;
import bank.management.models.enums.Status;
import bank.management.models.enums.TransactionType;
import bank.management.repositories.TransactionRepository;
import bank.management.services.AccountService;
import bank.management.services.CustomerService;
import bank.management.services.TransactionService;
import lombok.Builder;
import lombok.Data;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Resource(name = "TransactionService")
    private TransactionService transactionService;
    @Resource(name = "customerService")
    private CustomerService customerService;
    @Resource(name = "accountService")
    private AccountService accountService;

    @PostMapping("/newTransaction")
    public ResponseEntity<ResponseMessage> paymentTransaction(
            @RequestBody TransactionRequestDto transactionRequestDto) {

       Account account= accountService.getAccountByaccountNumber
               (transactionRequestDto.getAccountId());
        transactionService.SaveNewTransaction(transactionRequestDto,account);

        /*transactionRequestDto.setAmount(transactionRequestDto.getAmount());
        long id = transactionService.SaveNewTransaction(transaction);
        CustomerDto customer = new CustomerDto(customerNumber);
        AccountDto account = new AccountDto(AccountNumber);
        if (customerService.getCustomerByID(customer) != null ||
                accountService.getAccountByID(account) != null) {
            account = accountService.getAccountByID(account);
            if (account.getBalance() > amount) {
                transaction.setStatus(Status.Success);
                transaction.setRrn("123456");
                transaction.setUpdatedate(new Date());
                transaction.setLogResponse("موفق");
                long remain = account.getBalance() - amount;
                account.setBalance(remain);
                List<TransactionEntity> transactionList = new ArrayList<>();
                transactionList.add(transaction);
                account.setTransactions(transactionList);
                transaction.setAccount(account);
                transaction.setAmount(amount);

                transactionService.SaveOrUpdateNewTransaction(transaction);
                return ResponseEntity.status(HttpStatus.OK).body(ResponseMessage.builder().accountId(transaction.getId().toString()).build());
            } else {
                System.err.println("balance is low!");
                transaction.setLogResponse("ناموفق");
                transaction.setStatus(Status.Fail);
                transactionService.SaveOrUpdateNewTransaction(transaction);
                return ResponseEntity.status(HttpStatus.OK).body(ResponseMessage.builder().accountId(transaction.getId().toString()).build());
            }

        } else {
            System.err.println("customer not found");
            transaction.setLogResponse("ناموفق");
            transaction.setStatus(Status.Fail);
            transactionService.SaveOrUpdateNewTransaction(transaction);
            return ResponseEntity.status(HttpStatus.OK).body(ResponseMessage.builder().accountId(transaction.getId().toString()).build());
        }*/


    }

    @Data
    @Builder
    class ResponseMessage {
        private String paymentId;
    }
}
