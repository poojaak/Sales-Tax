
public class ConvertToItem implements ItemTypeConstants {

 public Item createItem(String itemInfo) {
        final String SPACE=" ";
        int itemQuantiy=Integer.parseInt(itemInfo.substring(0, itemInfo.indexOf(SPACE)));
        String itemName=itemInfo.substring(itemInfo.indexOf(SPACE)+1,itemInfo.lastIndexOf(SPACE)-3);
        double itemPrice=Double.parseDouble(itemInfo.substring(itemInfo.lastIndexOf(SPACE),itemInfo.length()));

        Item item=new Item(itemQuantiy,itemName,itemPrice);
        item=setTypeToImportedItem(itemName, item);

        return item;
    }

    private Item setTypeToImportedItem(String itemName, Item item) {
        if(itemName.contains(IMPORTED)){
            itemName=itemName.replace(IMPORTED,"");
            item.setItemName(itemName.trim());
            item.setTypeOfItem(IMPORTED);
        }
        else
            item.setTypeOfItem(LOCAL);

        return item;
    }
}
