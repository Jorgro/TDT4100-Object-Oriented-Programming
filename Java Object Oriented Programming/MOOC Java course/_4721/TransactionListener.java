package _4721;

public interface TransactionListener {
    void listenToTransaction(Account from, Account to, double amount);
}