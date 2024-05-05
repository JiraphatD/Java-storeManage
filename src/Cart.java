
import java.util.ArrayList;
import java.util.Iterator;

public class Cart extends Warehouse {
    private ArrayList<Product> bl;

    public Cart() {
        bl = new ArrayList<>();
    }
    
    public void AddItem(Product p) {
        bl.add(p);
    }
    public void DeleteItem(Product p, int quan) {
        Iterator it = bl.iterator();
        while (it.hasNext()) {
            if(quan==0) {
                break;
            }
            else {
                bl.remove(p);
            }
            quan--;
        }
    }
    public void DeleteItem(String name, int quan) {
        Iterator it = bl.iterator();
        while (it.hasNext()) {
            if(quan==0) {
                break;
            }
            Product p = (Product)it.next();
            if(p.getName().equals(name)) {
                it.remove();
            }
            quan--;
        }
    }
    public String Bill() {
        if(bl.isEmpty()) {
            return "No product found.";
        }
        int i;
        double price = 0;
        for(i=0; i<bl.size(); i++) {
            price += bl.get(i).getPrice();
        }
        return "Total "+price+" bath.";
    }
    public void resetCart() {
        bl = new ArrayList<>();
    }
    public void showCart() {
        if(bl.isEmpty()) {
            System.out.println("No product found.");
        }
        else {
            for(int i=0; i<bl.size(); i++) {
                System.out.println(bl.get(i));
            }
            System.out.println("-----");
        }
    }
}
