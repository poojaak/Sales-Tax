import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;


public class ItemListParserTest {
    List<Item> itemList;
    ItemListParser itemListParser=new ItemListParser();

    @Test
    public void shouldMakeAnItem(){
        Item book=new Item(1,"book",12.49);
        itemList=itemListParser.getItemsFromBasket("basket1.txt");

        Item retrievedItem=itemList.get(0);

        assertEquals(retrievedItem.getItemName(), book.getItemName());
        assertEquals(retrievedItem.getItemQuantity(), book.getItemQuantity());
        assertEquals(retrievedItem.getPrice(), book.getPrice(), 0);

    }
}
