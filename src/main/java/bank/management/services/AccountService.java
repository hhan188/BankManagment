package bank.management.services;

import bank.management.models.entities.Account;
import bank.management.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("accountService")
public class AccountService {
    @Autowired
    private AccountRepository repository;

    public Account getAccountByaccountNumber(Long accountId) {
        return repository.getReferenceById(accountId);
    }
}
