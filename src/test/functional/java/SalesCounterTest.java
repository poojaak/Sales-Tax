import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class SalesCounterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

       @Before
       public void setUpStreams() {
           System.setOut(new PrintStream(outContent));
       }

       @Test
       public void checkReceipt() {
           SalesCounter counter = new SalesCounter();
           counter.printReceipt("basket2.txt");

           String receipt = "Receipt 1\n" +
                   "1 imported box of chocolates: 10.50\n" +
                   "1 imported bottle of perfume: 54.65\n" +
                   "Sales Taxes: 7.65" + "\nTotal: 65.15";

           assertEquals(receipt, outContent.toString().trim());
       }

     @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
}