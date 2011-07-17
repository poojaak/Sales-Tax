import java.util.List;

public class SalesCounter {
    BasketOfGoods basketOfGoods=new BasketOfGoods();
    TotalAmountAndSalesTax totalAmountAndSalesTax=new TotalAmountAndSalesTax();
    Receipt receipt=new Receipt();
    
    public void printReceipt(String basket) {
        System.out.println("Receipt " + basketOfGoods.getBasketCount());
        List<Item> items=basketOfGoods.getItemsFromBasket(basket);
        totalAmountAndSalesTax.calculateTotalAmountAndSalesTax(items);
        receipt.print(basketOfGoods.listOfItemNameAndPrice(),totalAmountAndSalesTax);
    }
}
