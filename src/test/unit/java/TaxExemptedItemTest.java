import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TaxExemptedItemTest {
      @Test
    public void testCheckIfGoodsAreExemptedFromTax() throws Exception {
         Item book=new Item(1,"book",100.10);
         assertThat(new TaxExemptedItem().checkItemType(book), is(true));
    }
}
