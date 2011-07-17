
import java.util.List;

public class BasketOfGoods {
    private List<Item> itemList;
    static int basketCount = 1;
    private ItemListParser itemListParser;

    public BasketOfGoods() {
        itemListParser=new ItemListParser();
    }

    public static int getBasketCount() {
        return basketCount++;
    }

    public List<Item> getItemList(){
        return itemList;
    }

    public void setItemList(List<Item> itemList){
        this.itemList=itemList;
    }

    public List<Item> getItemsFromBasket(String items) {
        itemList=itemListParser.getItemsFromBasket(items);
        return itemList;
    }

    public String listOfItemNameAndPrice() {
        int count = 0;
        String listOfItems = "";
        Item item;
        while (count < itemList.size()) {
            item = itemList.get(count++);
            listOfItems += item + "\n";
        }
        return listOfItems;
    }
}
