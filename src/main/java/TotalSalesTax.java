import java.util.List;

public class TotalSalesTax {
    private InputReader reader=new InputReader();
    private Double salesTax;
    private Double total;
    private TaxCalculationOnItem calculator =new TaxCalculationOnItem();

    public void calculateTotalSalesTax(String items){
        List<Item> itemList;
        itemList = readItemsList(items);
        int nextItem=0;
        total=salesTax=0.0;
        Item item=new Item();

        while (nextItem<itemList.size()){

                item=itemList.get(nextItem);
                item.setSalesTax(calculator.calculatePriceAfterTaxation(item));
                salesTax+=item.getSalesTax()-item.getPrice();
                total+=itemList.get(nextItem++).getSalesTax();
        }
        salesTax=roundTax(salesTax);
    }

    private double roundTax(double tax){
        return Math.ceil(tax*20)/20;
    }

    private List<Item> readItemsList(String items) {
        List<Item> itemList;
        reader.readInputFromFile(items);
        itemList=reader.getItemList();
        return itemList;
    }

    public InputReader getReader() {
        return reader;
    }

     public Double getSalesTax() {
        return salesTax;
    }

    public Double getTotal(){
        return total;
    }
}
