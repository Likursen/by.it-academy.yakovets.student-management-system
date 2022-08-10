package net.javaguides.sms.ui.webDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSingleton {
    private static WebDriver webDriver;

    private WebDriverSingleton() {
    }

    public static WebDriver getWebDriver() {
        if (webDriver == null) {
            WebDriverManager.chromedriver()
                    .setup();
            webDriver = new ChromeDriver();
            webDriver.manage()
                    .window()
                    .maximize();
        }
        return webDriver;
    }

    public static void driverQuit() {
        webDriver.quit();
        webDriver = null;
    }
}