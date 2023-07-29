package bank.management.models.dtos;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AccountDto {

    private Integer id;
    private String AccountNumber;
    Set<Long> transactionsIds;
    private BranchDto branch;
    Set<Long>  customerId;
    private boolean status=true;
    private long balance;

}
