package org.sukrupa.cucumber.steps;

import cuke4duke.annotation.After;
import cuke4duke.annotation.I18n.EN.Then;
import cuke4duke.annotation.I18n.EN.When;
import net.sf.sahi.client.Browser;
import org.sukrupa.cucumber.SahiFacade;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.sukrupa.cucumber.SahiFacade.browser;

public class BasicWebSteps {

    private static final String TOP_LEVEL_DIV = "page";

    @When("^I click \"([^\"]*)\" button$")
    public void clickButton(String buttonText){
        browser().button(buttonText).click();
    }

    @When("^I click \"([^\"]*)\" submit button$")
    public void clickSubmitButton(String buttonText){
        browser().submit(buttonText).click();
    }

    @Then("^I should see \"([^\"]*)\"$")
    public void shouldSee(String text) {
        Browser browser = browser();
        assertTrue(browser.containsText(browser.div(TOP_LEVEL_DIV), text));
    }

    @When("^I click \"([^\"]*)\" link$")
    public void clickLink(String text){
        browser().link(text).click();
    }

    @Then("^I should not see \"([^\"]*)\"$")
    public void shouldNotSee(String text) {
        assertFalse(browser().containsText(browser().div("page"), text));
    }

    @After
    public void closeBrowser() {
        SahiFacade.closeBrowser();
    }
}
