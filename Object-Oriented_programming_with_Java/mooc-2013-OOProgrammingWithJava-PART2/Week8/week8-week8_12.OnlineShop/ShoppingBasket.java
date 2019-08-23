import java.util.HashMap;
import java.util.Map;

public class ShoppingBasket {
    private Map<String,Purchase> list;

    public ShoppingBasket () {
        this.list = new HashMap<String,Purchase>();
    }

    public void add(String product, int price) {
        Purchase newPurchase = new Purchase(product, 1, price);

        if(this.list.containsKey(product)) {
            this.list.get(product).increaseAmount();
        } else {
            this.list.put(product, newPurchase);
        }
    }

    public int price() {
        int total = 0;
        for (String p : this.list.keySet()) {
            total += this.list.get(p).price();
        }

        return total;
    }

    public void print() {
        for (String p : this.list.keySet()) {
            System.out.println(this.list.get(p));
        }

    }
}