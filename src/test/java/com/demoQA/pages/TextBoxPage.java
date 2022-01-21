package com.demoQA.pages;

import com.demoQA.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TextBoxPage {

    public TextBoxPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    /**
     * Below I used css. I prefer to use css or xpath or id.
     * For example, xpath = "//input[@id='userName']"
     * Or -> id = "userName"
     */
    @FindBy(css = "input#userName")
    public WebElement fullName_inputBox;

    @FindBy(css = "input#userEmail")
    public WebElement email_inputBox;

    @FindBy(css = "#currentAddress")
    public WebElement curAddress_inputBox;

    @FindBy(css = "#permanentAddress")
    public WebElement perAddress_inputBox;

    @FindBy(css = "button#submit")
    public WebElement submitBtn;

    @FindBy(css = "p#name")
    public WebElement name_Result;

    @FindBy(css = "p#email")
    public WebElement email_result;

    @FindBy(css = "p#currentAddress")
    public WebElement curAddress_result;

    @FindBy(css = "p#permanentAddress")
    public WebElement perAddress_result;

    @FindBy(css = "input#userEmail[class*='field-error']")
    public WebElement email_errorIndicator;

    @FindBy(css = "p.mb-1")
    public List<WebElement> resultsList;

    @FindBy(css = ".main-header" )
    public WebElement textBoxPageTitle;

}
