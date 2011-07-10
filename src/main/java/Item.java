
public class Item {

    private String itemName;
    private int itemQuantity;
    private double itemPrice;
    private double salesTax;

    public Item(int itemQuantity, String itemName, double itemPrice) {
        this.itemQuantity=itemQuantity;
        this.itemName=itemName;
        this.itemPrice=itemPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public double getPrice() {
        return itemPrice;
    }

    public double getSalesTax(){
        return salesTax;
    }

    public void setSalesTax(double tax){
        salesTax=tax;
    }
}
