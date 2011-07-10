import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SalesTaxCalculatorTest {

    @Test
    public void shouldCheckForGoodsAreExemptedFromTaxOrNot(){
        Item book=new Item(1,"books",27.99);
        SalesTaxCalculator calculator=new SalesTaxCalculator(book);
        assertThat(calculator.checkIfGoodsAreExemptedFromTax(book.getItemName()),is(true));
    }

    @Test
    public void shouldAssignTaxDependingOnTyeOfGood(){
        Item book=new Item(1,"books",27.99);
        SalesTaxCalculator calculator=new SalesTaxCalculator(book);
        assertThat(calculator.calculateTaxPercent(),is(0));
        Item pen=new Item(1,"pen",30.42);
        calculator.setItem(pen);
        assertThat(calculator.calculateTaxPercent(),is(10));
    }

     @Test
    public void shouldAssignTaxDependingOnTyeOfGoodIncludingImported(){
        Item book=new Item(1,"imported pills",27.99);
        SalesTaxCalculator calculator=new SalesTaxCalculator(book);
        assertThat(calculator.calculateTaxPercent(),is(5));
        Item pen=new Item(1,"imported pen",30.42);
        calculator.setItem(pen);
        assertThat(calculator.calculateTaxPercent(),is(15));
    }


}
