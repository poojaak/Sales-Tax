public class ImportedItem extends ItemType{

     public boolean checkItemType(Item item) {
          return item.getTypeOfItem().equals(IMPORTED);
    }

}
