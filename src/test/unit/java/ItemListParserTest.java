import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;


public class ItemListParserTest {
    List<Item> itemList;
    ItemListParser itemListParser=new ItemListParser();

    @Test
    public void shouldMakeAnItem(){
        Item book=new Item(1,"book",12.49);
        Item parsedItem=itemListParser.makeItem("1 book at 12.49");

        assertEquals(parsedItem.getItemName(), book.getItemName());
        assertEquals(parsedItem.getItemQuantity(), book.getItemQuantity());
        assertEquals(parsedItem.getPrice(), book.getPrice(), 0);

    }
}
