public class SalesTaxCalculator {
    Item item;

    SalesTaxCalculator(Item item){
        this.item=item;
    }

   

    public boolean checkIfGoodsAreExemptedFromTax(String itemName) {
        boolean flag=false;
        String exemptedlList[]={"books","box of choclates","pills","tablets"};

        for(int count=0;count<exemptedlList.length;count++){
            if(exemptedlList[count].indexOf(itemName)>=0){
                flag=true;
            }
        }
        return flag;
    }
}
