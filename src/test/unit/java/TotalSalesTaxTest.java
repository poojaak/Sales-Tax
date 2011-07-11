import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by IntelliJ IDEA.
 * User: poojaak
 * Date: 7/11/11
 * Time: 7:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class TotalSalesTaxTest {

    @Test
    public void checkSalesTax(){
        TotalSalesTax calculator=new TotalSalesTax();
        calculator.calculateTotalSalesTax("input.txt");
        assertThat(calculator.getSalesTax(),is(1.50));
       
    }

      @Test
    public void checkTotalAmount(){
        TotalSalesTax calculator=new TotalSalesTax();
        calculator.calculateTotalSalesTax("input.txt");
        assertThat(calculator.getTotal(),is(29.83));

    }

}
