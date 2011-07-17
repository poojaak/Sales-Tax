public class TaxCalculator {

    public static final int LOCAL_TAX_PERCENT = 10;
    public static final int IMPORTED_TAX_PERCENT = 5;

    public int calculateTaxPercent(Item item) {
        int salesTaxPercent = 0;
        ItemType typeOfItem = new TaxExemptedItem();
        boolean isExemptedGood = typeOfItem.checkItemType(item);
        typeOfItem = new ImportedItem();
        boolean isImportedGood = typeOfItem.checkItemType(item);
        return salesTaxPercent += (isExemptedGood ? 0 : LOCAL_TAX_PERCENT) + (isImportedGood ? IMPORTED_TAX_PERCENT : 0);
    }

    public double calculatePriceAfterTaxation(Item item) {
        double value = item.getItemQuantity() * (item.getPrice() * calculateTaxPercent(item) / 100);
        value = roundToNearestPointZeroFive(value);
        value = item.getPrice() + value;
        value = Double.parseDouble(String.format("%.2f", value));
        return value;

    }

    public double roundToNearestPointZeroFive(double value) {
        value = Math.ceil(value * 20) / 20;
        return value;
    }
}
