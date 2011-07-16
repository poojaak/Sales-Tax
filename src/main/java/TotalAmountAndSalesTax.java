
import java.util.List;
public class TotalAmountAndSalesTax  {
    private Double salesTax;
    private Double total;

    public Double getSalesTax() {
        return salesTax;
    }

    public Double getTotal(){
        return total;
    }

    public void calculateTotalAmountAndSalesTax(List<Item> itemList){
        int nextItem=0;
        total=salesTax=0.0;
        Item item;
        while (nextItem<itemList.size()){
            item=itemList.get(nextItem++);
            salesTax+=item.getSalesTax()-item.getPrice();
            total+=item.getSalesTax();
        }
        salesTax=roundToNearestPointZeroFive(salesTax);
        total=roundToNearestPointZeroFive(total);
    }

    public double roundToNearestPointZeroFive(double tax){
        return Double.parseDouble(String.format("%.2f",tax));
    }

    public String toString(){
        return "Sales Tax: "+getSalesTax()+"\nTotal: "+getTotal()+"\n";
    }
}
