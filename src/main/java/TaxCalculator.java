
public class TaxCalculator implements RoundToNearestValue{

    public static final int LOCAL_TAX_PERCENT = 10;
    public static final int IMPORTED_TAX_PERCENT = 5;

    public int calculateTaxPercent(Item item) {
        int salesTaxPercent=0;
        TypeOfItem typeOfItem=new TypeOfItem();
        boolean isExemptedGood = typeOfItem.checkIfGoodsAreExemptedFromTax(item);
        return salesTaxPercent+=(isExemptedGood?0: LOCAL_TAX_PERCENT) + (typeOfItem.checkIfItemIsImported(item)? IMPORTED_TAX_PERCENT :0);
   }

    public double calculatePriceAfterTaxation(Item item) {
           double value=item.getItemQuantity()*(item.getPrice()*calculateTaxPercent(item)/100);
           value = roundToNearestPointZeroFive(value);
           value=item.getPrice()+value;
           value=Double.parseDouble(String.format("%.2f",value));
           return value;

    }

    public double roundToNearestPointZeroFive(double value) {
        value=Math.ceil(value*20)/20;
        return value;
    }
}
