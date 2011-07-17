import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TotalAmountAndSalesTaxCalculatorTest {

      @Test
    public void checkTotalAmountAndSalesTax(){
          List<Item> items=new ArrayList<Item>();
          Item boxOfChoclates=new Item(1,"box of chocolates",10.00);
          boxOfChoclates.setTypeOfItem("imported");
          boxOfChoclates.calculateTax();
          items.add(boxOfChoclates);

          Item bottleOfPerfume=new Item(1,"bottle of perfume",47.50);
          bottleOfPerfume.setTypeOfItem("imported");
          bottleOfPerfume.calculateTax();
          items.add(bottleOfPerfume);

          TotalAmountAndSalesTaxCalculator calculator=new TotalAmountAndSalesTaxCalculator();

          calculator.calculateTotalAmountAndSalesTax(items);
          assertThat(calculator.getTotal(),is(65.15));
          assertThat(Double.parseDouble(String.format("%.2f", calculator.getSalesTax())), is(7.65));

    }

}
