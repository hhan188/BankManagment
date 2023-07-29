package bank.management.services;

import bank.management.models.dtos.TransactionRequestDto;
import bank.management.models.entities.TransactionEntity;
import bank.management.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.UUID;

@Service("TransactionService")
public class TransactionService {
    @Autowired
    private TransactionRepository repository;

    public long SaveNewTransaction(TransactionRequestDto transaction) {
        String rrn = String.valueOf(UUID.randomUUID());//شماره پیگیری
        Date insertDate = new Date();
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setAccount(transaction.getAccountId());
        transactionEntity.setAmount();
        repository.save()
    }
}
