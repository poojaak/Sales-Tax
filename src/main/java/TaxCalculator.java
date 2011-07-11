public class TaxCalculator implements RoundToNearestValue{

   public int calculateTaxPercent(Item item) {
        String itemName=item.getItemName();
        int salesTaxPercent=0;
        TypeOfItem typeOfItem=new TypeOfItem();
        boolean isExemptedGood = typeOfItem.checkIfGoodsAreExemptedFromTax(itemName);
        return salesTaxPercent+=(isExemptedGood?0:10) + (typeOfItem.checkIfItemIsImported(item)?5:0);
   }

    public double calculatePriceAfterTaxation(Item item) {
           double value=(item.getPrice()*calculateTaxPercent(item)/100);
           value = roundToNearestPointZeroFive(value);
           value=item.getPrice()+value;
           value=Double.parseDouble(String.format("%.2f",value));
           return value;
             //return Double.parseDouble(String.format("%.2f",item.getPrice()+(item.getPrice()*calculateTaxPercent(item)/100)));
    }

    public double roundToNearestPointZeroFive(double value) {
        value=Math.ceil(value*20)/20;
        return value;
    }
}
