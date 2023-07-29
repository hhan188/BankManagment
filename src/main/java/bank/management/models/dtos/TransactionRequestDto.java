package bank.management.models.dtos;

import bank.management.models.enums.Status;
import bank.management.models.enums.TransactionType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TransactionRequestDto {
    private TransactionType transactionType;
    private Long accountId;
   // private Status status;
    private long amount;


}
