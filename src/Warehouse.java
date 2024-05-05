import java.io.Serializable;
import java.util.*;

public class Warehouse implements Serializable {
    private HashMap map;
    private int numOfProduct;

    public Warehouse() {
        map = new HashMap();
    }

    public void addProduct(String name, String type, double price, int quantity) {
        map.put(name, new Product(name, type, price, quantity));
        System.out.println("Add Product Success.");
        System.out.println("Product Name : " + name + " Type : " + type + " Price : " + price +" Baht "+quantity+" ea.");
        numOfProduct++;
    }

    public void removeProduct(String name) {
        map.remove(name);
        System.out.println("Remove Product Success.");
        numOfProduct--;
    }

    public void editProduct(String name, String type, double price, int quantity) {
        map.put(name, new Product(name, type, price, quantity));
        System.out.println("Product Name : " + name + " Type : " + type + " Price : " + price +" Baht "+quantity+" ea.");
        System.out.println("Edit Success.");
        // Product value = (Product) map.get(name);
        // double p = value.getPrice();
        // System.out.println(p);
    }

    public void stock() {
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            Product value = (Product) map.get(pair.getKey());
            String name = value.getName();
            String type = value.getType();
            double price = value.getPrice();
            int quantity = value.getQuantity();
            System.out.println("Product Name : " + name + "\nType : " + type + "\nPrice : " + price +" Baht "+quantity+" ea. \n");
        }
    }
    public Iterator getStock() {
        Iterator it = map.entrySet().iterator();
        return it;
    }
    public HashMap getMap(){
        return map;
    }
    public void check_product() {
        if(numOfProduct==0) {
            System.out.println("Not Found.");
        }
        else {
            System.out.println(numOfProduct+" products have been found.");
        }
    }
    public boolean search_product(String s) {
        Product p = (Product)map.get(s);
        if(p==null) {
            System.out.println("Not Found.");
            return false;
        }
        else {
            System.out.println("Found.");
            return true;
        }
    }
    public Product select_product(String name) {
        Product p = (Product)map.get(name);
        return p;
    }

    
}