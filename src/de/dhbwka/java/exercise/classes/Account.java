package de.dhbwka.java.exercise.classes;

/**
 * Account
 */
public class Account {
    // #region private members
    private int accountNumber;
    private String name;
    private long balance;
    private int limit;
    // #endregion private members

    // #region constructors
    Account(String name) {
        this(name, 0, 100000);
    }

    Account(String name, int limit) {
        this(name, 0, limit);
    }

    Account(String name, long balance) {
        this(name, balance, 100000);
    }

    Account(String name, long balance, int limit) {
        setName(name);
        setBalance(balance);
        setLimit(limit);
        setAccountNumber((int) (Math.random() * 100000));
    }

    // #endregion constructors

    // #region GetSet
    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccountNumber(int accountNumer) {
        this.accountNumber = accountNumer;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public int getLimit() {
        return limit;
    }

    // #endregion GetSet

    // #region public methods
    public void processPayment(long pay) {
        if (pay > 0) {
            long newBalance = getBalance() - pay;
            if (newBalance > (limit * -1))
                setBalance(newBalance);
            else
                System.out.println("Deckung nicht ausreichend!");
        }
    }

    public void processDeposit(long dep) {
        if (dep > 0)
            setBalance(getBalance() + dep);
    }

    public String toString() {
        return "Konto Nr." + getAccountNumber() + " (" + getName() + "), Stand: " + getBalance() + " ct, Limit: "
                + getLimit() + " ct";
    }
    // #endregion public methods
}