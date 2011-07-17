import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SalesCounterTest {
    @Test
    public void checkSalesCounter() {
        BasketOfGoods basketOfGoods = new BasketOfGoods();
        List<Item> itemList = basketOfGoods.getItemsFromBasket("basket3.txt");

        TotalAmountAndSalesTaxCalculator calculator = new TotalAmountAndSalesTaxCalculator();
        calculator.calculateTotalAmountAndSalesTax(itemList);

        assertThat(itemList.size(),is(4));

        assertThat(itemList.get(0).getSalesTax(),is(32.19));
        assertThat(itemList.get(1).getSalesTax(),is(20.89));
        assertThat(itemList.get(2).getSalesTax(),is(9.75));
        assertThat(itemList.get(3).getSalesTax(),is(11.85));

        assertThat(calculator.getSalesTax(),is(6.70));
        assertThat(calculator.getTotal(),is(74.68));
    }

}
