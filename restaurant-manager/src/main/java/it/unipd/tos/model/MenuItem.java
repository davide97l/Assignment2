////////////////////////////////////////////////////////////////////
// [Davide] [Liu] [1140717]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.model;

public class MenuItem {
    public static enum itemType {Pizze,Primi}
    private String name;
    private double price;
    
    itemType type;
    public itemType getItemType() {
        return type;
    }
    public void setItemType(itemType type) {
        this.type=type;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

   public MenuItem(itemType type,String name,double price) {
       setItemType(type);
       setName(name);
       setPrice(price);
   }
    
}
