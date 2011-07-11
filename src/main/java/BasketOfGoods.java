import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BasketOfGoods implements ItemTyeConstants{
    List<Item> itemList;
    TotalSalesTax tax=new TotalSalesTax();
    Receipt receipt=new Receipt();


    public boolean basketExist(String basket){
        try{
            File fileName=new File(basket);
            return fileName.exists();
        }catch (Exception e){
            System.out.print("File not Found");
        }
        return false;
    }

    public Boolean readItemsFromBasket(String basket) {
        itemList=new ArrayList<Item>();
        if (basketExist(basket)){
            BufferedReader reader= null;
            try {
                reader = new BufferedReader(new FileReader(basket));
                String line=null;
                while ((line=reader.readLine())!=null){
                   makeItem(line);
                }
                return true;
            }catch (IOException e) {
                System.out.println("Unable to read from file");
            }
        }
        return false;


    }

    private void makeItem(String itemInfo) {
        final String SPACE=" ";
        int itemQuantiy=Integer.parseInt(itemInfo.substring(0, itemInfo.indexOf(SPACE)));
        String itemName=itemInfo.substring(itemInfo.indexOf(SPACE)+1,itemInfo.lastIndexOf(SPACE)-3);
        double itemPrice=Double.parseDouble(itemInfo.substring(itemInfo.lastIndexOf(SPACE),itemInfo.length()));

        Item item=new Item(itemQuantiy,itemName,itemPrice);
        item=setTypeToImportedItem(itemName, item);

        itemList.add(item);
    }

    private Item setTypeToImportedItem(String itemName, Item item) {
        if(itemName.contains(IMPORTED)){
            itemName=itemName.replace(IMPORTED,"");
            item.setItemName(itemName);
            item.setTypeOfItem(IMPORTED);
        }
        else
            item.setTypeOfItem(LOCAL);

        return item;
    }

    public List<Item> getItemList() {
        return itemList;
    }


    public void printReceipt(String items){
        readItemsFromBasket(items);
        tax.calculateTotalSalesTax(itemList);
        receipt.print(itemList,tax);

    }



}
