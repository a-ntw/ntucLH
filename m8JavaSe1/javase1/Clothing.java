
package javase1;

public class Clothing {
    // fields given default values
    private int itemID = 0;
    private String desc = "- description required -";
    private char colorCode = 'U';
    private double price = 0.0;
    
    // Constructor
    public Clothing(int itemID, String desc, char color, double price) {
        this.itemID = itemID;
        this.desc = desc;
        this.colorCode = color;
        this.price = price;
    }
    
    
    public Clothing(double price) {
        this.price = price;
        
        display();
    }
    
    public void display() {
        System.out.println("Item ID: " + getItemID());
        System.out.println("Shirt description: " + getDesc());
        System.out.println("Shirt price: " + getPrice());
        System.out.println("Color Code: " + colorCode);
    }    
    public String getDesc () {
        return desc;
    }
    public double getPrice() {
        return price;
    }
    public int getItemID() {
        return itemID;
    }
    protected void setColorCode(char color) {
        this.colorCode = color;
    }
}

