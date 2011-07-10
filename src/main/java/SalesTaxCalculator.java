public class SalesTaxCalculator {
    Item item;

    SalesTaxCalculator(Item item){
        this.item=item;
    }

   public int calculateTaxPercent() {
        String itemName=item.getItemName();
        int salesTaxPercent=0;
        boolean isExemptedGood = checkIfGoodsAreExemptedFromTax(itemName);
        return salesTaxPercent+=(isExemptedGood?0:10) + (checkIfItemIsImported(itemName)?5:0);
   }

    private boolean checkIfItemIsImported(String itemName) {
        if (itemName.contains("imported"))
            return true;
        else  
            return false;
    }

    public boolean checkIfGoodsAreExemptedFromTax(String itemName) {
        boolean flag=false;
        String exemptedlList[]={"book","box of choclate","pills","tablets"};

        for (String anExemptedlList : exemptedlList) {
            if (itemName.contains(anExemptedlList)) {
                flag = true;
            }
        }
        return flag;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
