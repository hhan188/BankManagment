package bank.management.services;

import bank.management.models.dtos.TransactionRequestDto;
import bank.management.models.entities.TransactionEntity;
import bank.management.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("TransactionService")
public class TransactionService {
    @Autowired
    private TransactionRepository repository;

    public long SaveNewTransaction(TransactionRequestDto transaction) {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setAccount(transaction.getAccountId());
        transactionEntity.setAmount();
        repository.save()
    }
}
