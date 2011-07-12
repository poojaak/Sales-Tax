import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TotalSalesTaxTest {

    @Test
    public void checkSalesTax(){
        TotalSalesTax calculator=new TotalSalesTax();
        BasketOfGoods basket=new BasketOfGoods();
        basket.readItemsFromBasket("basket2.txt");

        calculator.calculateTotalSalesTax(basket.getItemList());

        assertThat(Double.parseDouble(String.format("%.2f",calculator.getSalesTax())), is(7.65));

    }

      @Test
    public void checkTotalAmount(){
          TotalSalesTax calculator=new TotalSalesTax();
          BasketOfGoods basket=new BasketOfGoods();
          basket.readItemsFromBasket("basket2.txt");

          calculator.calculateTotalSalesTax(basket.getItemList());

          assertThat(calculator.getTotal(),is(65.15));

    }

}
