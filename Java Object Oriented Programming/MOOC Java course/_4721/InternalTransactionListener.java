package _4721;

public class InternalTransactionListener implements TransactionListener {

    @Override
    public void listenToTransaction(Account from, Account to, double amount) {
        if (from.getOwner().equals(to.getOwner())) {
            System.out.println("Samme eier overførte: " + amount);
        }
    }



}