import java.math.BigDecimal;

public class BankAccount {
    private BigDecimal balance;

    public BankAccount(BigDecimal initialBalance) {
        if (initialBalance.compareTo(BigDecimal.ZERO) == -1) {
            throw new IllegalArgumentException("A created account can only have positive values: "+initialBalance);
        } else {
            balance = initialBalance;
        }
    }

    public void withdraw(BigDecimal amount) throws InsufficientBalanceException {
        if (amount.compareTo(BigDecimal.ZERO) == -1) {
            throw new IllegalArgumentException("Only positive values can be withdrawn: "+amount);
        } else if ((balance.subtract(amount).compareTo(BigDecimal.ZERO) == -1)) {
            String message = String.format("Not enough balance! Balance: %s, Amount: %s", balance.toString(),
                    amount.toString());
            throw new InsufficientBalanceException(message);
        } else {
            balance = balance.subtract(amount);
        }
    }

    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) == -1) {
            throw new IllegalArgumentException("Only positive values can be deposited: "+amount);
        } else {
            balance.add(amount);
        }
    }

    public BigDecimal balance() {
        return balance;
    }

    @Override
    public String toString() {
        return String.format("Balance: %.2f", balance);
    }
}

/*long accountNumber;
    long totalAmount;

    public long getAccountNumber() {
        return accountNumber;
    }

    public long getTotalAmount() {
        return totalAmount;
    }

    public void depositAmount(long amount) {
        if(amount<0){
            throw new IllegalArgumentException("Amount must be positive");
        }
        totalAmount += amount;
    }

    public long withdrawAmount(long amount){
        totalAmount -= amount;
        return amount;
    }*/