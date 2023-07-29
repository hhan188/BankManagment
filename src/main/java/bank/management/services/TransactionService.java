package bank.management.services;

import bank.management.models.dtos.TransactionRequestDto;
import bank.management.models.entities.Account;
import bank.management.models.entities.TransactionEntity;
import bank.management.models.enums.Status;
import bank.management.models.enums.TransactionType;
import bank.management.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("TransactionService")
public class TransactionService {
    @Autowired
    private TransactionRepository repository;

    public long SaveNewTransaction(TransactionRequestDto transaction, Account account) {
        String rrn = String.valueOf(UUID.randomUUID());//شماره پیگیری
        Date insertDate = new Date();
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setAccount(account);
        transactionEntity.setAmount(transaction.getAmount());
        transactionEntity.setRrn(rrn);
        transactionEntity.setInsertdate(insertDate);
        transactionEntity.setStatus(Status.Inprogress);
        transactionEntity.setTransactionType(transaction.getTransactionType());
        repository.save(transactionEntity);
        if (transaction.getTransactionType() == TransactionType.Payment) {
            if (account.getBalance() < transaction.getAmount()) {
                transactionEntity.setStatus(Status.Fail);
                transactionEntity.setLogResponse("Fail");
                transactionEntity.setUpdatedate(new Date());
                repository.save(transactionEntity);
                return ;
                //todo : response postman
            }
        }
        transactionEntity.setStatus(Status.Success);
        transactionEntity.setLogResponse("Success");
        transactionEntity.setUpdatedate(new Date());
        account.getTransactions().add(transactionEntity);
        /*List<TransactionEntity> transactions = new ArrayList<>();
        transactions.add(transactionEntity);*/
        /*account.setTransactions(transactions);*/
        repository.save(transactionEntity);
        //todo : response postman
        return ;
    }
}
