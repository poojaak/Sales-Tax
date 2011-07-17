
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ItemListParser {

    public List<Item> takeItemsFromBasket(String basket) {
        List<Item> itemList = new ArrayList<Item>();
        Item item;

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(basket));
            String line = null;
            while ((line = reader.readLine()) != null) {
                item = makeItem(line);
                item.calculateTax();
                itemList.add(item);
            }
        } catch (IOException e) {
            System.out.println("Unable to retrieve from basket");
        }

        return itemList;
    }

    public Item makeItem(String itemInfo) {
        ConvertToItem convertToItem = new ConvertToItem();
        return convertToItem.createItem(itemInfo);
    }

}
