public class TaxCalculationOnItem {

   public int calculateTaxPercent(Item item) {
        String itemName=item.getItemName();
        int salesTaxPercent=0;
        boolean isExemptedGood = checkIfGoodsAreExemptedFromTax(itemName);
        return salesTaxPercent+=(isExemptedGood?0:10) + (checkIfItemIsImported(itemName)?5:0);
   }

    private boolean checkIfItemIsImported(String itemName) {
        return itemName.contains("imported");
    }

    public boolean checkIfGoodsAreExemptedFromTax(String itemName) {
        boolean flag=false;
        String exemptedlList[]={"book","chocolate","pills","tablets"};
        int count=0;
        for(count=0;count<exemptedlList.length;count++){
            if(itemName.indexOf(exemptedlList[count])>=0){
                flag=true;
            }
        }
        return flag;
    }



    public double calculatePriceAfterTaxation(Item item) {
           double value=(item.getPrice()*calculateTaxPercent(item)/100);
           value = roundToNearestPointZeroFive(value);
           value=item.getPrice()+value;
           value=Double.parseDouble(String.format("%.2f",value));
           return value;
             //return Double.parseDouble(String.format("%.2f",item.getPrice()+(item.getPrice()*calculateTaxPercent(item)/100)));
    }

    private double roundToNearestPointZeroFive(double value) {
        value=Math.ceil(value*20)/20;
        return value;
    }
}
