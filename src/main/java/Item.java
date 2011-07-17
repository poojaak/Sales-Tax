
public class Item implements ItemTypeConstants {

    private String itemName;
    private int itemQuantity;
    private double itemPrice;
    private double salesTax;
    private String typeOfItem;
    private TaxCalculator calculator;


    public Item(){
    }

    public Item(int itemQuantity, String itemName, double itemPrice) {
        this.itemQuantity=itemQuantity;
        this.itemName=itemName;
        this.itemPrice=itemPrice;
        this.calculator=new TaxCalculator();
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

     public void setItemName(String itemName){
        this.itemName=itemName;
    }

    public void calculateTax(){
        setSalesTax(calculator.calculatePriceAfterTaxation(this));
    }

    public String toString() {
        String format=getItemQuantity()+ " ";
        if(getTypeOfItem().equals(IMPORTED)){
            format+=getTypeOfItem() +" ";
        }
        return format+=getItemName() + ": " + String.format("%.2f",getSalesTax());
    }
}
