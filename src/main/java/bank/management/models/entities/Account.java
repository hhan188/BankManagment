package bank.management.models.entities;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/*import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;*/
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Builder
//@Audited
public class Account {
    @Id
    @Column(name = "Account_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "AccountNumber")
    private String AccountNumber;
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<TransactionEntity> transactions = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;
    @ManyToMany(mappedBy = "accounts")
    private Set<Customer> customers = new HashSet<>();
    @Column(name = "status")
    private boolean status=true;
    @Column(name="balance")
    private long balance;

    public Account(String account_number) {
        AccountNumber = account_number;
    }
}
