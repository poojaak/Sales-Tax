
public class Item {

    private String itemName;
    private int itemQuantity;
    private double itemPrice;
    private double salesTax;
    private String typeOfItem;

    public Item(int itemQuantity, String itemName, double itemPrice) {
        this.itemQuantity=itemQuantity;
        this.itemName=itemName;
        this.itemPrice=itemPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public String getTypeOfItem() {
        return typeOfItem;
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

    public void setTypeOfItem(String typeOfItem){
        this.typeOfItem=typeOfItem;
    }

    public Item(){

    }
}
