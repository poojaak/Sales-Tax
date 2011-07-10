public class SalesTaxCalculator {
    Item item;

    SalesTaxCalculator(Item item){
        this.item=item;
    }

   public int calculateTaxPercent() {
        String itemName=item.getItemName();
        int salesTaxPercent=0;
        boolean flag = checkIfGoodsAreExemptedFromTax(itemName);
        return salesTaxPercent+=flag?0:10;

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

    public void setItem(Item item) {
        this.item = item;
    }
}
