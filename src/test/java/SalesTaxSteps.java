package test.java;

import cuke4duke.annotation.I18n.EN.Given;
import cuke4duke.annotation.I18n.EN.Then;

import java.lang.String;

import static junit.framework.Assert.assertEquals;

@SuppressWarnings({"UnusedDeclaration"})
public class SalesTaxSteps {
    private int salesTax=0;

    @Given("^the goods are among books, food and medical products$")
    public void assignTheGoods() {
        salesTax+=0;
    }

    @Given("^the goods are imported$")
    public void checkForImportedGoods() {
            salesTax+=5;
    }

    @Given("^the goods are not among books, food and medical products$")
    public void assignTheNotExemptedGoods(){
          salesTax+=10;
    }

    @Then("^the sales tax is ([^\"]+) on each good$")
    public void checkSalesTax(String tax) {
        String calculatedTax="";
        if(salesTax==0)
            calculatedTax="exempted";
        else
            calculatedTax=salesTax+"%";
        assertEquals(tax,calculatedTax);
    }
}
