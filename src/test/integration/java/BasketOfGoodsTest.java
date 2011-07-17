import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BasketOfGoodsTest {
    @SuppressWarnings("unchecked")
    @Test
    public void testGetItemsFromBasket() throws Exception {
        BasketOfGoods basketOfGoods = new BasketOfGoods();
        List<Item> itemList = basketOfGoods.getItemsFromBasket("basket2.txt");

        List<Item> items = new ArrayList<Item>();
        Item boxOfChocolates = new Item(1, "box of chocolates", 10.00);
        boxOfChocolates.setTypeOfItem("imported");
        boxOfChocolates.calculateTax();
        items.add(boxOfChocolates);

        Item bottleOfPerfume = new Item(1, "bottle of perfume", 47.50);
        bottleOfPerfume.setTypeOfItem("imported");
        bottleOfPerfume.calculateTax();
        items.add(bottleOfPerfume);

        assertThat(itemList.get(0).getItemName(), is(items.get(0).getItemName()));
        assertThat(itemList.get(0).getItemQuantity(), is(items.get(0).getItemQuantity()));
        assertThat(itemList.get(0).getPrice(), is(items.get(0).getPrice()));
        assertThat(itemList.get(0).getSalesTax(), is(items.get(0).getSalesTax()));
        assertThat(itemList.get(0).getTypeOfItem(), is(items.get(0).getTypeOfItem()));

        assertThat(itemList.get(1).getItemName(), is(items.get(1).getItemName()));
        assertThat(itemList.get(1).getItemQuantity(), is(items.get(1).getItemQuantity()));
        assertThat(itemList.get(1).getPrice(), is(items.get(1).getPrice()));
        assertThat(itemList.get(1).getSalesTax(), is(items.get(1).getSalesTax()));
        assertThat(itemList.get(1).getTypeOfItem(), is(items.get(1).getTypeOfItem()));
    }

}
