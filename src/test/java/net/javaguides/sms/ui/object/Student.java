package net.javaguides.sms.ui.object;

import org.openqa.selenium.WebElement;

public class Student {
    private String firstName;
    private String lastName;
    private String email;
    private WebElement buttonUpdate;
    private WebElement buttonDelete;

    public Student() {

    }

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public Student setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Student setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Student setEmail(String email) {
        this.email = email;
        return this;
    }

    public WebElement getButtonUpdate() {
        return buttonUpdate;
    }

    public Student setButtonUpdate(WebElement buttonUpdate) {
        this.buttonUpdate = buttonUpdate;
        return this;
    }

    public WebElement getButtonDelete() {
        return buttonDelete;
    }

    public Student setButtonDelete(WebElement buttonDelete) {
        this.buttonDelete = buttonDelete;
        return this;
    }
}