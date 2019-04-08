package _4721;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Bank implements Iterable<Account>, FinancialInstitution{


    List<Account> accounts = new ArrayList<Account>();
    bankIO bankIO = new bankIO();

    List<TransactionListener> listeners = new ArrayList<TransactionListener>();

    public Bank() {

    }

    public void removeAccount(Account account) {
        if (accounts.contains(account)) {
            accounts.remove(account);
        }
        
    }

    public void addAccount(Account account) {
        if (!accounts.contains(account)) {
            accounts.add(account);
        }
    }

    public void bankTransfer(Account account, Bank newBank) {
        removeAccount(account);
        newBank.addAccount(account);
    }

    public void bankTransfer(List<Account> accounts, Bank newBank) {
        accounts.stream().forEach(acc -> bankTransfer(acc, newBank));
    }

    public void accountTransfer(Account from, Account to, int amount) {
        from.withdraw(amount);
        to.deposit(amount);
        listeners.forEach(c -> c.listenToTransaction(from, to, amount));
    }

    public int getTotalAmount() {
        return (int) this.accounts.stream().mapToDouble(c -> c.getBalance()).sum();
    }

    public Map<String, Double> getPersonBalance() {
        //Tolker oppgaven som at du vil ha den totale summen hver unike person har i banken. 
        Map<String, Double> accs = new HashMap<String, Double>();

        //Var nødt til å lage en getter for eieren til kontoen siden variabelen var satt til private. 
        this.accounts.stream().map(Account::getOwner).distinct().forEach(c -> accs.put(c, (double) 0));
        for (Account acc : this.accounts) {
            accs.put(acc.getOwner(), accs.get(acc.getOwner()) + acc.getBalance());
        }

        return accs;

    } 

    public void sortByBalance() {
        this.accounts.sort((a, b) -> (int) (b.getBalance() - a.getBalance()));
    }

    public void sortByName() {
        this.accounts.sort((a, b) -> b.getOwner().compareTo(a.getOwner()));
    }

    public static void main(String[] args) {
        Bank dnb = new Bank();
        dnb.addAccount(new Account(1000, 0, "J"));
        dnb.addAccount(new Account(3000, 0, "A"));
        dnb.addAccount(new Account(2500, 0, "B"));

        dnb.sortByBalance();
        System.out.println(dnb.accounts.toString());
        dnb.sortByName();
        System.out.println(dnb.accounts.toString());
        
    }

    @Override
    public Iterator<Account> iterator() {
        return this.accounts.iterator();
    }
    //Double/int? Vet den ikke fungerer 
    //public int getTotalAmount() {
    //    return (int) getTotalAmount();
    //}

    @Override
    public boolean isSafe() {
        if (!(this.accounts.stream().map(Account::getOwner).distinct().count() >= 10))
            return false;

        if (!(this.accounts.size() >= 20))
            return false;
        
        if (!(getTotalAmount() >= Math.pow(10, 7)))
            return false;
        
        if(this.accounts.stream().filter(c -> (c.getInterestRate() > 0.03)).count() > 5)
            return false;

        return true;
    }

    public void load(String filename) throws FileNotFoundException {

        List<Account> newAccounts = bankIO.getBankAccounts(filename);
        newAccounts.stream().forEach(c -> addAccount(c));
    }

    public void removeListener(TransactionListener list) {
        if (listeners.contains(list)) {
            listeners.remove(list);
        }
    }

    public void addListeners(TransactionListener list) {
        if (!listeners.contains(list)) {
            listeners.add(list);
        }
    }



}