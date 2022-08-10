package net.javaguides.sms.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditStudentsPage extends BasePage {

    @FindBy(xpath = "//h1")
    private WebElement headerPage;

    @FindBy(xpath = "//div[@class='form-group'][1]/label")
    private WebElement labelsFirstName;

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement inputFirstName;

    @FindBy(xpath = "//div[@class='form-group'][2]/label")
    private WebElement labelsLastName;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement inputLastName;

    @FindBy(xpath = "//div[@class='form-group'][2]/label")
    private WebElement labelsEmail;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonSubmitForm;

    public StudentsPage clickSubmit() {
        buttonSubmitForm.submit();
        return new StudentsPage();
    }

    public boolean isHeaderPageDisplayed() {
        return headerPage.isDisplayed();
    }

    public boolean isLabelsFirstNameDisplayed() {
        return labelsFirstName.isDisplayed();
    }

    public boolean isLabelsLastNameDisplayed() {
        return labelsLastName.isDisplayed();
    }

    public boolean isLabelsEmailDisplayed() {
        return labelsEmail.isDisplayed();
    }

    public boolean isButtonSubmitFormDisplayed() {
        return buttonSubmitForm.isDisplayed();
    }

    public EditStudentsPage typeFirstName(String firstName) {
        inputFirstName.clear();
        inputFirstName.sendKeys(firstName);
        return this;
    }

    public EditStudentsPage typeLastName(String lastName) {
        inputLastName.clear();
        inputLastName.sendKeys(lastName);
        return this;
    }

    public EditStudentsPage typeEmail(String email) {
        inputEmail.clear();
        inputEmail.sendKeys(email);
        return this;
    }
}