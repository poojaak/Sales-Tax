package test.java;

import cuke4duke.annotation.I18n.EN.Given;
import cuke4duke.annotation.I18n.EN.Then;

import static junit.framework.Assert.assertEquals;

@SuppressWarnings({"UnusedDeclaration"})
public class SalesTaxSteps {
    private String typeOfGoods="";
    private int salesTax=0;

    @Given("^the goods are ([^\"]+)$")
    public void assignTheGoods(String typeOfGoods) {
        this.typeOfGoods+=" "+typeOfGoods;
         if(typeOfGoods.contains("not"))
            salesTax=10;
         else if(typeOfGoods.contains("books, food and medical products"))
            salesTax+=0;
         if(typeOfGoods.contains("imported"))
            salesTax+=5;
    }

    @Then("^the sales tax is ([^\"]+) on each good$")
    public void theGreetingIs(String tax) {
        String calculatedTax="";
        if(salesTax==0)
            calculatedTax="exempted";
        else
            calculatedTax=salesTax+"%";
        assertEquals(tax,calculatedTax);
    }
}
