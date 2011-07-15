import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class BasketOfGoodsTest {
    List<Item> itemList;
    BasketOfGoods basketOfGoods =new BasketOfGoods();

    @Test
    public void checkFileExist() throws FileNotFoundException {
        assertThat(basketOfGoods.basketExist("basket1.txt"),is(true));
    }

    @Test
    public void shouldReadInput() throws FileNotFoundException {
        assertThat(basketOfGoods.readItemsFromBasket("basket1.txt"), is(true));
    }

    @Test
    public void shouldMakeAnItem(){
        Item book=new Item(1,"book",12.49);
        basketOfGoods.readItemsFromBasket("basket1.txt");
        itemList= basketOfGoods.getItemList();
        Item retrievedItem=itemList.get(0);

        assertEquals(retrievedItem.getItemName(),book.getItemName());
        assertEquals(retrievedItem.getItemQuantity(),book.getItemQuantity());
        assertEquals(retrievedItem.getPrice(),book.getPrice(),0);

    }
}
