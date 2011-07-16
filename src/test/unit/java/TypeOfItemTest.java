import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TypeOfItemTest {
    @Test
    public void testCheckIfItemIsImported() throws Exception {
        Item book=new Item(1,"book",100.10);
        book.setTypeOfItem("imported");
        assertThat(new TypeOfItem().checkIfItemIsImported(book), is(true));
    }

    @Test
    public void testCheckIfGoodsAreExemptedFromTax() throws Exception {
         Item book=new Item(1,"book",100.10);
         assertThat(new TypeOfItem().checkIfGoodsAreExemptedFromTax(book), is(true));
    }
}
