import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SalesCounterTest {
    @Test
    public void checkgetItemsFromBasketIsInvoked(){
        BasketOfGoods basketOfGoods = mock(BasketOfGoods.class);
        basketOfGoods.getItemsFromBasket("basket");
        verify(basketOfGoods).getItemsFromBasket("basket");
    }

     @SuppressWarnings("unchecked")
     @Test
    public void checkCalculateTotalAmountAndSalesTaxIsInvoked(){
         List<Item> list=mock(List.class);
        TotalAmountAndSalesTax totalAmountAndSalesTax = mock(TotalAmountAndSalesTax.class);
        totalAmountAndSalesTax.calculateTotalAmountAndSalesTax(list);
        verify(totalAmountAndSalesTax).calculateTotalAmountAndSalesTax(list);
    }

     @Test
    public void checkPrintMethodIsInvoked(){
        Receipt receipt=mock(Receipt.class);
        TotalAmountAndSalesTax tax=mock(TotalAmountAndSalesTax.class);
        receipt.print("listOfItems",tax);
        verify(receipt).print("listOfItems",tax);
    }

}
