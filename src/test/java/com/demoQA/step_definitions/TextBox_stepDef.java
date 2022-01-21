package com.demoQA.step_definitions;

import com.demoQA.pages.TextBoxPage;
import com.demoQA.utilities.BrowserUtils;
import com.demoQA.utilities.ConfigurationReader;
import com.demoQA.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.StandardSocketOptions;

public class TextBox_stepDef {
    TextBoxPage textBoxPage = new TextBoxPage();

    @Given("the user navigates to {string} page")
    public void the_user_navigates_to_page(String expectedHeader) {

        Driver.get().get(ConfigurationReader.get("textBoxPage_url"));

        WebDriverWait wait = new WebDriverWait(Driver.get(),3);
        wait.until(ExpectedConditions.visibilityOf(textBoxPage.textBoxPageTitle));

        String actualHeader = textBoxPage.textBoxPageTitle.getText();
        Assert.assertEquals(expectedHeader, actualHeader);
    }

    @When("the user enters {string}, {string}, {string}, {string}")
    public void the_user_enters(String fullName, String email, String curAddress, String perAddress) {
       textBoxPage.fullName_inputBox.sendKeys(fullName);
       textBoxPage.email_inputBox.sendKeys(email);
       textBoxPage.curAddress_inputBox.sendKeys(curAddress);
       textBoxPage.perAddress_inputBox.sendKeys(perAddress);
    }

    @And("the user clicks on text box submit button")
    public void the_user_clicks_on_text_box_submit_button() {
        textBoxPage.submitBtn.click();
    }

    @Then("the correct {string}, {string}, {string}, {string} should be displayed")
    public void the_correct_should_be_displayed(String fullName, String email, String curAddress, String perAddress) {
        WebDriverWait wait = new WebDriverWait(Driver.get(),3);
        wait.until(ExpectedConditions.visibilityOf(textBoxPage.name_Result));

        BrowserUtils.scrollToElement(textBoxPage.perAddress_result);

        String expectedFullName = "Name:" + fullName;
        String actualFullName = textBoxPage.name_Result.getText();
        Assert.assertEquals(expectedFullName,actualFullName);

        String expectedEmail = "Email:" + email;
        String actualEmail = textBoxPage.email_result.getText();
        Assert.assertEquals(expectedEmail,actualEmail);

        String expectedCurrentAddress = "Current Address :" + curAddress;
        String actualCurrentAddress = textBoxPage.curAddress_result.getText();
        Assert.assertEquals(expectedCurrentAddress,actualCurrentAddress);

        String expectedPermanentAddress = "Permananet Address :" + perAddress;
        String actualPermanentAddress = textBoxPage.perAddress_result.getText();
        Assert.assertEquals(expectedPermanentAddress,actualPermanentAddress);
    }

    @When("the user enters invalid {string}")
    public void the_user_enters_invalid(String email) {
        textBoxPage.email_inputBox.sendKeys(email);
    }


    @Then("email input has error indicator and there is no output")
    public void email_input_has_errorIndicator_and_there_is_no_output() {
        Assert.assertTrue(textBoxPage.email_errorIndicator.isDisplayed());

        Assert.assertTrue(textBoxPage.resultsList.isEmpty());
    }


}
