package bank.management.services;

import bank.management.models.entities.Customer;
import bank.management.repositories.AccountRepository;
import bank.management.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("customerService")
public class CustomerService {
    @Autowired
    private CustomerRepository repository;
    public Object getCustomerByCustomerNumber(Customer customer) {
    }
}
