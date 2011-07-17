import java.util.List;

public class SalesCounter {
    BasketOfGoods basketOfGoods;
    TotalAmountAndSalesTaxCalculator calculator =new TotalAmountAndSalesTaxCalculator();
    Receipt receipt=new Receipt();

    SalesCounter(){
        basketOfGoods=new BasketOfGoods();
    }

    public void printReceipt(String basket) {
        System.out.print("Receipt " + BasketOfGoods.getBasketCount() +"\n");
        List<Item> items=basketOfGoods.getItemsFromBasket(basket);
        calculator.calculateTotalAmountAndSalesTax(items);
        receipt.print(basketOfGoods.listOfItemNameAndPrice(), calculator);
    }

}
