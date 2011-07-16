import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TotalAmountAndSalesTaxTest {

    @Test
    public void checkSalesTax(){
        TotalAmountAndSalesTax calculator=new TotalAmountAndSalesTax();
        BasketOfGoods basket=new BasketOfGoods();
        basket.readItemsFromBasket("basket2.txt");

        calculator.calculateTotalAmountAndSalesTax(basket.getItemList());

        assertThat(Double.parseDouble(String.format("%.2f",calculator.getSalesTax())), is(7.65));

    }

      @Test
    public void checkTotalAmount(){
          TotalAmountAndSalesTax calculator=new TotalAmountAndSalesTax();
          BasketOfGoods basket=new BasketOfGoods();
          basket.readItemsFromBasket("basket2.txt");

          calculator.calculateTotalAmountAndSalesTax(basket.getItemList());

          assertThat(calculator.getTotal(),is(65.15));

    }

}
