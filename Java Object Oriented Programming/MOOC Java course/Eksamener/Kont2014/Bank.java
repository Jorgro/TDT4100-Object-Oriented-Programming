package Eksamener.Kont2014;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Bank {

    private int number = 0;
    protected Collection<Account> accounts = new ArrayList<>();
    protected Collection<Transaction> transactions = new ArrayList<>();

    public void addAccount(Account acc) {
        if (!isTaken(acc.getAccountId())) {
            accounts.add(acc);
        }
    }

    private Account getAccount(String number) {
        if (this.accounts.stream().anyMatch(c -> c.getAccountId().equals(number))) {
            return this.accounts.stream().filter(c -> c.getAccountId().equals(number)).findFirst().get();
        }
        return null;
    }

    public void createAccount() {
        while (isTaken(Integer.toString(number))) {
            number++;
        }
        this.accounts.add(new Account(Integer.toString(number)));
    }

    private boolean isTaken(String number) {
        return this.accounts.stream().anyMatch(c -> c.getAccountId().equals(number));
    }

    public void transfer(Account source, Account target, int amount) throws IllegalArgumentException {
        if (!(this.accounts.contains(source) && this.accounts.contains(target))) {
            throw new IllegalArgumentException();
        }
        try {
            Transaction t = new Transaction(source, target, amount);
            source.withdraw(amount);
            target.deposit(amount);
            transactions.add(t);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public int getTransferSum(Account account, int year, int month) {
        int sum = 0;
        for (Transaction t : this.transactions) {
            if (t.date.getMonth() == month && t.date.getYear() == year) {
                if (t.source.equals(account)) {
                    sum += t.amount;
                }
            }
        }
        return sum;
    }

    public void doTransaction(InputStream in) {
        Scanner sc = new Scanner(in);
        // format source-target-amount
        while (sc.hasNextLine()) {
            String[] s = sc.nextLine().split("-");
            Account target = getAccount(s[1]);
            Account source = getAccount(s[0]);
            if (target != null && source != null) {
                try {
                    transfer(source, target, Integer.valueOf(s[2]));
                } catch (Exception e) {

                }
            }
        }
    }

}