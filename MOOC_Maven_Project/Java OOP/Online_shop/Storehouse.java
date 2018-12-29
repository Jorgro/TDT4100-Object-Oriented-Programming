package Online_shop;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Storehouse {
    private Map<String, Integer> productPrices;
    private Map<String, Integer> productStocks;

    public Storehouse() {
        this.productPrices = new HashMap<String, Integer>();
        this.productStocks = new HashMap<String, Integer>();
    }

    public void addProduct(String product, int price, int stock) {
        this.productPrices.put(product, price);
        this.productStocks.put(product, stock);
    }

    public int price(String product) {
        if (this.productPrices.containsKey(product)) {
            return this.productPrices.get(product);
        }
        return -99;

    }

    public int stock(String product) {
        if (this.productStocks.containsKey(product)) {
            return this.productStocks.get(product);
        }
        return 0;
    }

    public boolean take(String product) {
        if (!this.productStocks.containsKey(product)) {
            return false;
        }

        if (this.stock(product) > 0) {
            this.productStocks.put(product, this.stock(product)-1);
            return true;
        }
        
        return false;
    }

    public Set<String> products() {
        Set<String> products = this.productPrices.keySet();
        return products;
    }

    public static void main(String[] args) {
        Storehouse store = new Storehouse();
        store.addProduct("milk", 3, 10);
        store.addProduct("coffee", 5, 6);
        store.addProduct("buttermilk", 2, 20);
        store.addProduct("jogurt", 2, 20);

        System.out.println("products:");
        for (String product : store.products()) {
            System.out.println(product);
        }
    }
}
