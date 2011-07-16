package test.java;

import cuke4duke.annotation.I18n.EN.Given;
import cuke4duke.annotation.I18n.EN.Then;
import main.java.BasketOfGoods;
import main.java.Item;
import main.java.ItemListParser;
import main.java.TotalAmountAndSalesTax;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class SalesTaxSteps
{
    BasketOfGoods basketOfGoods=new BasketOfGoods();
    List<Item> itemList=new ArrayList<Item>();
    String itemWithPrice[]=new String[4];
    TotalAmountAndSalesTax totalAmountAndSalesTax=new TotalAmountAndSalesTax();
    int itemNum =0;

    @Given("^the price of ([^\"]*)$")
    public void getGoods(String itemInfo){
     ItemListParser itemListParser=new ItemListParser();
     Item item=itemListParser.makeItem(itemInfo);
     item.calculateTax();
     itemList.add(item);
    }

    @Then("^the cost of ([^\"]*) becomes ([^\"]*)$")
    public void getReceipt(String itemName,String tax){
        assertEquals(itemList.get(itemNum++).getSalesTax(),Double.parseDouble(tax));
    }

   
    @Then("^the Sales Tax becomes ([^\"]*)")
    public void checkSalesTax(String salesTax){
        totalAmountAndSalesTax.calculateTotalAmountAndSalesTax(itemList);
         assertEquals(totalAmountAndSalesTax.getSalesTax(),Double.parseDouble(salesTax));
    }

    @Then("^the Total Amount becomes ([^\"]*)")
    public void checkTotalAmount(String totalAmount){
        assertEquals(totalAmountAndSalesTax.getTotal(),Double.parseDouble(totalAmount));
    }
    

}