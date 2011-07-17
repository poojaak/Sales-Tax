import java.util.List;

public class SalesCounter {
    BasketOfGoods basketOfGoods;
    TotalAmountAndSalesTaxCalculator calculator;
    Receipt receipt;

    SalesCounter(){
        basketOfGoods=new BasketOfGoods();
        calculator =new TotalAmountAndSalesTaxCalculator();
        receipt=new Receipt();
    }

    public void printReceipt(String basket) {
        System.out.print("Receipt " + BasketOfGoods.getBasketCount() +"\n");
        List<Item> items=basketOfGoods.getItemsFromBasket(basket);
        calculator.calculateTotalAmountAndSalesTax(items);
        receipt.print(basketOfGoods.listOfItemNameAndPrice(), calculator);
    }

}
