package net.javaguides.sms.ui;

import net.javaguides.sms.ui.webDriver.WebDriverSingleton;
import org.testng.annotations.AfterMethod;

public abstract class BaseTest {

    @AfterMethod
    protected void afterTest() {
        WebDriverSingleton.driverQuit();
    }
}