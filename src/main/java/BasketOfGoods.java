import java.util.List;

public class BasketOfGoods implements ItemTyeConstants {
    private List<Item> itemList;
    private TotalAmountAndSalesTax tax;
    private Receipt receipt;
    static int basketCount = 0;
    private ItemListParser itemListParser;

    public BasketOfGoods() {
        basketCount++;
        tax = new TotalAmountAndSalesTax();
        itemListParser=new ItemListParser();
        receipt = new Receipt();
    }

    public static int getBasketCount() {
        return basketCount;
    }

    public void printReceipt(String items) {
        System.out.println("Receipt " + getBasketCount());
        itemList=itemListParser.getItemsFromBasket(items);
        calculateTotalAmountAndSalesTaxToBePaid(itemList);
        String listOfItems = listOfItemNameAndPrice();
        receipt.print(listOfItems, tax);
    }

    private void calculateTotalAmountAndSalesTaxToBePaid(List<Item> itemList) {
        tax.calculateTotalAmountAndSalesTax(itemList);
    }

    private String listOfItemNameAndPrice() {
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
