import java.util.List;

public class SalesCounter {
    BasketOfGoods basketOfGoods=new BasketOfGoods();
    TotalAmountAndSalesTaxCalculator calculator =new TotalAmountAndSalesTaxCalculator();
    Receipt receipt=new Receipt();
    
    public void printReceipt(String basket) {
        System.out.println("Receipt " + basketOfGoods.getBasketCount());
        List<Item> items=basketOfGoods.getItemsFromBasket(basket);
        calculator.calculateTotalAmountAndSalesTax(items);
        receipt.print(basketOfGoods.listOfItemNameAndPrice(), calculator);
    }
}
