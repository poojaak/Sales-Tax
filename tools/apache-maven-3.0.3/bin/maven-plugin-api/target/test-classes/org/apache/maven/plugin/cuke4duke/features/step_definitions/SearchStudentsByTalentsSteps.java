package org.sukrupa.cucumber.steps;


import cuke4duke.annotation.I18n.EN.*;
import cuke4duke.annotation.Pending;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.sukrupa.cucumber.SahiFacade.browser;

public class SearchStudentsByTalentsSteps extends BasicWebSteps{

    @When("^I select the talent \"([^\"]*)\"$")
    public void selectTalent(String talent) {
        browser().select("availableTalents").choose(talent);
	    browser().button("addTalent").click();
    }
}
