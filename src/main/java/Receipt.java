import java.util.List;

public class Receipt implements ItemTyeConstants{

    public void print(List<Item> itemList,TotalSalesTax tax){
        listItemNameAndPrice(itemList);
        printSalesTaxAndTotal(tax);
    }

    private void listItemNameAndPrice(List<Item> itemList) {
        int count=0;
        while (count<itemList.size()){
            printItemInformation(itemList.get(count));
            count++;
        }

    }

    private void printSalesTaxAndTotal(TotalSalesTax tax) {
        System.out.println("Sales Tax: "+String.format("%.2f",tax.getSalesTax()));
        System.out.println("Total: "+String .format("%.2f",tax.getTotal()));
        System.out.println();
    }

    private void printItemInformation(Item item) {
        System.out.print(item.getItemQuantity()+ " ");
        if(item.getTypeOfItem().equals(IMPORTED)){
            System.out.print(IMPORTED +" ");
        }
        System.out.println(item.getItemName() + ": " + item.getSalesTax());

        
       
    }
}
