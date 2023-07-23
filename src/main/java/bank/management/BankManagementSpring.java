package bank.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "bank.management")
@EntityScan(basePackages = "bank.management")
@ComponentScan(basePackages = "bank.management")
//@EnableJpaAuditing
//@EnableTransactionManagement
//@EnableCaching
public class BankManagementSpring {
    public static void main(String[] args) {
        SpringApplication.run(BankManagementSpring.class, args);
    }




}
