package Eksamener.Kont2014;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SafeBank extends Bank {

    Map<Account, Integer> limits = new HashMap<>();

    public void setLimit(Account acc, int limit) {
        this.limits.put(acc, limit);
    }

    @Override
    public void transfer(Account source, Account target, int amount) throws IllegalArgumentException {
        if (!(accounts.contains(source) && accounts.contains(target))) {
            throw new IllegalArgumentException();
        }

        try {
            int limit = limits.get(source);
            Date d = new Date();
            if (getTransferSum(source, d.getYear(), d.getMonth()) + amount > limit) {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
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

}