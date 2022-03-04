
package javase1;

public class Shirt extends Clothing {
    private char fit = 'U';

    public Shirt(int itemID, String description, char 
            colorCode, double price, char fit) {
        super(itemID, description, colorCode, price);
        
        this.fit = fit;
    }
    public char getFit() {
        return fit;
    }
    public void setFit(char fit) {
        this.fit = fit;
    }
    public Shirt (char fit) {
        this(15.00, fit);
    }
    public Shirt(double price, char fit) {
        super(price);
        this.fit = fit;
    }

}    