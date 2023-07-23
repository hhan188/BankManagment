package bank.management.models.entities;

import bank.management.models.enums.Status;
import bank.management.models.enums.TransactionType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Cacheable
@org.hibernate.annotations.Cache(usage= CacheConcurrencyStrategy.READ_ONLY)

public class TransactionEntity {
    @Id
    @Column(name = "Transaction_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    @Column(name = "rrn")
    private String rrn;
    @Column(name = "logResponse")
    private String logResponse;
    @Column(name = "status")
    private Status status;
    @Column(name = "amount")
    private long amount;
    @Column(name = "InsertDate")
    @Temporal(TemporalType.DATE)
    private Date Insertdate;
    @Temporal(TemporalType.DATE)
    @Column(name = "UpdateDate")
    private Date Updatedate;


    public TransactionEntity(TransactionType transactionType) {
        this.transactionType = transactionType;
    }


}
