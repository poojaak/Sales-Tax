import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ConvertToItemTest {
    @Test
    public void testCreateItemOfImportedType() throws Exception {
        ConvertToItem convertToItem = new ConvertToItem();
        Item perfumeConverted = convertToItem.createItem("1 imported bottle of perfume at 18.99");
        Item perfume = new Item(1, "bottle of perfume", 18.99);
        perfume.setTypeOfItem("imported");

        assertThat(perfumeConverted.getItemName().trim(), is(perfume.getItemName()));
        assertThat(perfumeConverted.getItemQuantity(), is(perfume.getItemQuantity()));
        assertThat(perfumeConverted.getPrice(), is(perfumeConverted.getPrice()));
        assertThat(perfumeConverted.getTypeOfItem(), is(perfume.getTypeOfItem()));
    }

    @Test
    public void testCreateItemOfLocalType() throws Exception {
        ConvertToItem convertToItem = new ConvertToItem();
        Item perfumeConverted = convertToItem.createItem("1 bottle of perfume at 18.99");
        Item perfume = new Item(1, "bottle of perfume", 18.99);

        assertThat(perfumeConverted.getItemName().trim(), is(perfume.getItemName()));
        assertThat(perfumeConverted.getItemQuantity(), is(perfume.getItemQuantity()));
        assertThat(perfumeConverted.getPrice(), is(perfumeConverted.getPrice()));
    }

}
