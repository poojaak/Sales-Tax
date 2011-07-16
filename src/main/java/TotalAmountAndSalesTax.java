import java.util.List;

public class TotalAmountAndSalesTax implements RoundToNearestValue{
    private Double salesTax;
    private Double total;

    public void calculateTotalAmountAndSalesTax(List<Item> itemList){

        int nextItem=0;
        total=salesTax=0.0;
        Item item;

        while (nextItem<itemList.size()){
            item=itemList.get(nextItem);
            salesTax+=item.getSalesTax()-item.getPrice();
            total+=itemList.get(nextItem++).getSalesTax();
        }

        salesTax=roundToNearestPointZeroFive(salesTax);
        total=roundToNearestPointZeroFive(total);
        
    }

    public double roundToNearestPointZeroFive(double tax){
        return Double.parseDouble(String.format("%.2f",tax));
    }

    public Double getSalesTax() {
        return salesTax;
    }

    public Double getTotal(){
        return total;
    }

    public String toString(){
        return "Sales Tax: "+getSalesTax()+"\nTotal: "+getTotal()+"\n";
    }
}
