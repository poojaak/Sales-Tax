public class ConvertToItem implements ItemTypeConstants {

    public Item createItem(String itemInfo) {
        final String SPACE = " ";
        int firstSpace = itemInfo.indexOf(SPACE);
        int lastSpace = itemInfo.lastIndexOf(SPACE);

        int itemQuantity = Integer.parseInt(itemInfo.substring(0, firstSpace));
        String itemName = itemInfo.substring(firstSpace + 1, lastSpace - 3);
        double itemPrice = Double.parseDouble(itemInfo.substring(lastSpace, itemInfo.length()));

        Item item = new Item(itemQuantity, itemName, itemPrice);
        item = setTypeToImportedItem(itemName, item);

        return item;
    }

    private Item setTypeToImportedItem(String itemName, Item item) {
        if (itemName.contains(IMPORTED)) {
            item.setItemName(itemName.replace(IMPORTED, "").trim());
            item.setTypeOfItem(IMPORTED);
        } else
            item.setTypeOfItem(LOCAL);

        return item;
    }
}
