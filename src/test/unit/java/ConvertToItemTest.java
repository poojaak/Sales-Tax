import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ConvertToItemTest {
    @Test
    public void testCreateItem() throws Exception {
        ConvertToItem convertToItem=new ConvertToItem();
        Item perfumeConverted=convertToItem.createItem("1 bottle of perfume at 18.99");
        Item perfume=new Item(1,"bottle of perfume",18.99);
        MatcherAssert.assertThat(perfumeConverted.getItemName(), is(perfume.getItemName()));
        assertThat(perfumeConverted.getItemQuantity(),is(perfume.getItemQuantity()));
        assertThat(perfumeConverted.getPrice(),is(perfumeConverted.getPrice()));
    

    }


}
