package bank.management.models.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TransactionType {
    Payment(1),
    Purchase(2),
    Deposit(3),
    Balance(4),
    Transfer(5),
    Cashout(8),
    CashableBalance(9),
    Statement(10),
    ;

    private final int value;

    TransactionType(int val) {
        this.value = val;
    }

    public static TransactionType valueOf(int val) {
        for (TransactionType as : TransactionType.values())
            if (as.getValue() == val)
                return as;
        return null;
    }


    public int getValue() {
        return value;
    }
}
