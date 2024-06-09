
package Digigarage.Entity;

public class Accessory {
    String ID;
    String name;
    int stock;
    int price;

    public Accessory(String ID, String name, int stock, int price) {
        this.ID = ID;
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Accessory{" + "ID=" + ID + ", name=" + name + ", stock=" + stock + ", price=" + price + '}';
    }
    
}
