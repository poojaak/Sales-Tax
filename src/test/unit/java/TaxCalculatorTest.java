import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TaxCalculatorTest {
    @Test
    public void shouldAssignTaxDependingOnTyeOfGood(){
        Item book=new Item(1,"books",27.99);
        book.setTypeOfItem("local");
        TaxCalculator calculator =new TaxCalculator();
        assertThat(calculator.calculateTaxPercent(book),is(0));
        Item pen=new Item(1,"pen",30.42);
        pen.setTypeOfItem("local");
        assertThat(calculator.calculateTaxPercent(pen),is(10));
    }

     @Test
    public void shouldAssignTaxDependingOnTyeOfGoodIncludingImported(){
        Item book=new Item(1,"imported pills",27.99);
        TaxCalculator calculator =new TaxCalculator();
        book.setTypeOfItem("imported");
        assertThat(calculator.calculateTaxPercent(book),is(5));
        Item pen=new Item(1,"imported pen",30.42);
        pen.setTypeOfItem("imported");
        assertThat(calculator.calculateTaxPercent(pen),is(15));
    }

    @Test
    public void shouldCalculateCorrectTax(){
        Item book=new Item(1,"chocolate",0.85);
         book.setTypeOfItem("local");
        TaxCalculator calculator =new TaxCalculator();

        assertThat(calculator.calculatePriceAfterTaxation(book), is(0.85));
        Item perfume=new Item(1,"imported bottle of perfume",27.99);
          perfume.setTypeOfItem("imported");
        assertThat(calculator.calculatePriceAfterTaxation(perfume),is(32.19));

    }

}

