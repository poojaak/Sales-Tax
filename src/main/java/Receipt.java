import java.util.List;

public class Receipt {
   OnEachInput input=new OnEachInput();

    public void printReport(){
        input.calculateTax();
        List<Item> itemList=input.getReader().getItemList();
        int numOfItems=1;
        int count=0;
        int nextItem=0;
        double total=0;
        while(numOfItems<=input.getSalesTax().size()){
            System.out.println("Output " + numOfItems);
            while (count<input.getReader().getNumOfItemsPerInput(numOfItems)){
                total+=itemList.get(nextItem).getSalesTax();
                printOutputItem(itemList.get(nextItem++));
                count++;
            }
            System.out.println("Sales Tax: "+String.format("%.2f",input.getSalesTax().get(numOfItems-1)));
            System.out.println("Total: "+String .format("%.2f",total));
            System.out.println();
            count=0;
            total=0;
            numOfItems++;
        }


    }

    private void printOutputItem(Item item) {
        System.out.println(item.getItemQuantity() + " " + item.getItemName() + ": " + item.getSalesTax());
    }
}
