import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SalesCounterTest {
    @Test
    public void checkgetItemsFromBasketIsInvoked() {
        BasketOfGoods basketOfGoods = mock(BasketOfGoods.class);
        basketOfGoods.getItemsFromBasket("basket");
        verify(basketOfGoods).getItemsFromBasket("basket");
    }

    @SuppressWarnings("unchecked")
    @Test
    public void checkCalculateTotalAmountAndSalesTaxIsInvoked() {
        List<Item> list = mock(List.class);
        TotalAmountAndSalesTaxCalculator totalAmountAndSalesTax = mock(TotalAmountAndSalesTaxCalculator.class);
        totalAmountAndSalesTax.calculateTotalAmountAndSalesTax(list);
        verify(totalAmountAndSalesTax).calculateTotalAmountAndSalesTax(list);
    }

    @Test
    public void checkPrintMethodIsInvoked() {
        Receipt receipt = mock(Receipt.class);
        TotalAmountAndSalesTaxCalculator tax = mock(TotalAmountAndSalesTaxCalculator.class);
        receipt.print("listOfItems", tax);
        verify(receipt).print("listOfItems", tax);
    }

}
