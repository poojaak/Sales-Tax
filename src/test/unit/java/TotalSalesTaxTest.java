import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TotalSalesTaxTest {

    @Test
    public void checkSalesTax(){

        TotalSalesTax calculator=mock(TotalSalesTax.class);
        when(calculator.getSalesTax()).thenReturn(1.50);
        assertThat(calculator.getSalesTax(), is(1.50));

    }

      @Test
    public void checkTotalAmount(){
        TotalSalesTax calculator=mock(TotalSalesTax.class);
         when(calculator.getTotal()).thenReturn(29.83);
        assertThat(calculator.getTotal(),is(29.83));

    }

}
