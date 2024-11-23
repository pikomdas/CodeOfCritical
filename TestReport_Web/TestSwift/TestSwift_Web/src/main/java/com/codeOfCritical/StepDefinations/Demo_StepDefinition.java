package com.codeOfCritical.StepDefinations;

import com.codeOfCritical.BaseClass.Browser;
import com.codeOfCritical.commonUtils.CustomExecutionStatus;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Demo_StepDefinition extends Browser {

    ThreadLocal<String> urlLength = new ThreadLocal<>();

    @When("I search for title length 11")
    public void iSearchForTitleLength() {
        urlLength.set(String.valueOf(driverThread.get().getCurrentUrl().length()));
        System.out.println(urlLength.get());
    }

    @Given("I open {string} url")
    public void iOpenUrl(String ws) throws Exception {
        startBrowser("chrome");
        driverThread.get().get(ws);
    }

    @Then("It will be length of {string}")
    public void itWillBeLengthOf(String arg0) {

        CustomExecutionStatus.getInstance()
                .verifyStringDataFromJSONtoUI("11", urlLength.get(), "URL length are same", driverThread.get().getTitle(), "URL");
    }
}
