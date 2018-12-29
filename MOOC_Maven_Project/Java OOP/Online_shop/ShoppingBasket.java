package Online_shop;

import java.util.LinkedList;
import java.util.List;

public class ShoppingBasket {

    List<Purchase> purchases;

    public ShoppingBasket() {
        this.purchases = new LinkedList<Purchase>();

    }

    public void add(String product, int price) {
        for (Purchase purchase : this.purchases) {
            if (purchase.getProduct().equals(product)) {
                purchase.increaseAmount();
                return;
            }
        }
        
        Purchase purchase = new Purchase(product, 1, price);
        this.purchases.add(purchase);
    }

    public int price() {
        int price = 0;
        for (Purchase purchase : this.purchases) {
            price += purchase.price();
        }

        return price;
    }

    public void print() {
        for (Purchase purchase : this.purchases) {
            System.out.println(purchase);
        }
    }

    public static void main(String[] args) {
        ShoppingBasket basket = new ShoppingBasket();
        basket.add("milk", 3);
        basket.print();
        System.out.println("basket price: " + basket.price() +"\n");

        basket.add("buttermilk", 2);
        basket.print();
        System.out.println("basket price: " + basket.price() +"\n");

        basket.add("milk", 3);
        basket.print();
        System.out.println("basket price: " + basket.price() +"\n");

        basket.add("milk", 3);
        basket.print();
        System.out.println("basket price: " + basket.price() +"\n");
    }

}