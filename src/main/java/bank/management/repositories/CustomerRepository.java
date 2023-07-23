package bank.management.repositories;

import bank.management.models.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface CustomerRepository extends JpaRepository<Customer, Long> {


}
