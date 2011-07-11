import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TaxCalculationOnItemTest {

    @Test
    public void shouldCheckForGoodsAreExemptedFromTaxOrNot(){
        TaxCalculationOnItem calculationOnItem =new TaxCalculationOnItem();
        assertThat(calculationOnItem.checkIfGoodsAreExemptedFromTax("books"),is(true));
    }

    @Test
    public void shouldAssignTaxDependingOnTyeOfGood(){
        Item book=new Item(1,"books",27.99);
        TaxCalculationOnItem calculationOnItem =new TaxCalculationOnItem();
        assertThat(calculationOnItem.calculateTaxPercent(book),is(0));
        Item pen=new Item(1,"pen",30.42);
        assertThat(calculationOnItem.calculateTaxPercent(pen),is(10));
    }

     @Test
    public void shouldAssignTaxDependingOnTyeOfGoodIncludingImported(){
        Item book=new Item(1,"imported pills",27.99);
        TaxCalculationOnItem calculationOnItem =new TaxCalculationOnItem();
        assertThat(calculationOnItem.calculateTaxPercent(book),is(5));
        Item pen=new Item(1,"imported pen",30.42);
        assertThat(calculationOnItem.calculateTaxPercent(pen),is(15));
    }

    @Test
    public void shouldCalculateCorrectTax(){
        Item book=new Item(1,"chocolate",0.85);

        TaxCalculationOnItem calculationOnItem =new TaxCalculationOnItem();

        assertThat(calculationOnItem.calculatePriceAfterTaxation(book), is(0.85));
        Item perfume=new Item(1,"imported bottle of perfume",27.99);
//        assertThat(calculationOnItem.calculatePriceAfterTaxation(perfume),is(32.19));

        Receipt report=new Receipt();
        report.printReceipt("input.txt");



    }




}
