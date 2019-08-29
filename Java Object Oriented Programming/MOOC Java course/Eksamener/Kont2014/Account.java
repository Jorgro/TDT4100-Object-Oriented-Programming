package Eksamener.Kont2014;

public class Account {
    private final String accountNumber;
    private int balance = 0;
    private int limit = 10000;

    public Account(String number) {
        if (number.matches("[0-9]*") && number.length() >= 2) {
            this.accountNumber = number;
        }
        throw new IllegalArgumentException();
    }

    public int getBalance() {
        return balance;
    }

    private void setLimit(int limit) {
        testNegative(limit);
        this.limit = limit;
    }

    public String getAccountId() {
        return this.accountNumber;
    }

    public void deposit(int amount) {
        testNegative(amount);
        balance += amount;
    }

    public void withdraw(int amount) {
        testNegative(amount);
        if (amount > this.limit) {
            throw new IllegalArgumentException();
        }
        balance -= amount;
    }

    public static void testNegative(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException();
        }
    }
}