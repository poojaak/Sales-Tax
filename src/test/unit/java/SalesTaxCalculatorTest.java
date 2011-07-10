import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SalesTaxCalculatorTest {

    @Test
    public void shouldCheckForGoodsAreExemptedFromTaxOrNot(){
        Item book=new Item(1,"book",27.99);
        SalesTaxCalculator calculator=new SalesTaxCalculator(book);
        assertThat(calculator.checkIfGoodsAreExemptedFromTax(book.getItemName()),is(true));
    }

}
