import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TotalAmountAndSalesTaxTest {

    private ItemListParser itemListParser=new ItemListParser();

    @Test
    public void checkSalesTax(){
        TotalAmountAndSalesTax calculator=new TotalAmountAndSalesTax();
        calculator.calculateTotalAmountAndSalesTax(itemListParser.getItemsFromBasket("basket2.txt"));
        assertThat(Double.parseDouble(String.format("%.2f",calculator.getSalesTax())), is(7.65));

    }

      @Test
    public void checkTotalAmount(){
          TotalAmountAndSalesTax calculator=new TotalAmountAndSalesTax();
          calculator.calculateTotalAmountAndSalesTax(itemListParser.getItemsFromBasket("basket2.txt"));
          assertThat(calculator.getTotal(),is(65.15));

    }

}
