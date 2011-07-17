import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ReceiptPrintTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void checkPrintReceipt() {
        BasketOfGoods basketOfGoods = new BasketOfGoods();
        List<Item> items = new ArrayList<Item>();
        Item boxOfChocolates = new Item(1, "box of chocolates", 10.00);
        boxOfChocolates.setTypeOfItem("imported");
        boxOfChocolates.calculateTax();
        items.add(boxOfChocolates);

        Item bottleOfPerfume = new Item(1, "bottle of perfume", 47.50);
        bottleOfPerfume.setTypeOfItem("imported");
        bottleOfPerfume.calculateTax();
        items.add(bottleOfPerfume);

        basketOfGoods.setItemList(items);

        TotalAmountAndSalesTaxCalculator calculator = new TotalAmountAndSalesTaxCalculator();
        calculator.calculateTotalAmountAndSalesTax(items);

        Receipt receipt = new Receipt();
        receipt.print(basketOfGoods.listOfItemNameAndPrice(), calculator);

        String receiptExpected = "1 imported box of chocolates: 10.50\n" +
                "1 imported bottle of perfume: 54.65\n" +
                "Sales Taxes: 7.65" + "\nTotal: 65.15";

        assertEquals(receiptExpected, outContent.toString().trim());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
}
