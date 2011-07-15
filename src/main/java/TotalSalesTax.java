import java.util.List;

public class TotalSalesTax implements RoundToNearestValue{
    private Double salesTax;
    private Double total;
    private TaxCalculator calculator =new TaxCalculator();

    public void calculateTotalSalesTax(List<Item> itemList){

        int nextItem=0;
        total=salesTax=0.0;
        Item item;

        while (nextItem<itemList.size()){

                item=itemList.get(nextItem);
                item.setSalesTax(calculator.calculatePriceAfterTaxation(item));
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
}
