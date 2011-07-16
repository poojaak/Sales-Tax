import java.util.List;

public class Receipt implements ItemTyeConstants{

    public void print(List<Item> itemList,TotalSalesTax tax){
        listItemNameAndPrice(itemList);
        printSalesTaxAndTotal(tax);
    }

    private void listItemNameAndPrice(List<Item> itemList) {
        int count=0;
        String printFormatForItem;
        while (count<itemList.size()){
            printFormatForItem=itemList.get(count).toString();
            System.out.println(printFormatForItem);
            count++;
        }
    }

    private void printSalesTaxAndTotal(TotalSalesTax tax) {
        System.out.println("Sales Tax: "+String.format("%.2f",tax.getSalesTax()));
        System.out.println("Total: "+tax.getTotal());
        System.out.println();
    }


}
