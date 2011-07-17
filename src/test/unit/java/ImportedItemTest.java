import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ImportedItemTest {
    @Test
    public void testCheckIfItemIsImported() throws Exception {
        Item book=new Item(1,"book",100.10);
        book.setTypeOfItem("imported");
        assertThat(new ImportedItem().checkItemType(book), is(true));
    }
}
