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
    static int basketCount=0;

    public BasketOfGoods(){
        basketCount++;
    }

    public static int getBasketCount(){
        return basketCount;
    }

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
        Item item;
        if (basketExist(basket)){
            BufferedReader reader= null;
            try {
                reader = new BufferedReader(new FileReader(basket));
                String line=null;
                while ((line=reader.readLine())!=null){
                   item=makeItem(line);
                   item.calculateTax();
                   itemList.add(item);
                }
                return true;
            }catch (IOException e) {
                System.out.println("Unable to retrieve from basket");
            }
        }
        return false;


    }

   public Item makeItem(String itemInfo){
        ConvertToItem convertToItem=new ConvertToItem();
        return convertToItem.createItem(itemInfo);
   }

    public List<Item> getItemList() {
        return itemList;
    }

    public void printReceipt(String items){
        System.out.println("Receipt "+getBasketCount());
        readItemsFromBasket(items);
        tax.calculateTotalSalesTax(itemList);
        receipt.print(itemList,tax);

    }



}
