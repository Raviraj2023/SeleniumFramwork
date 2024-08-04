package org.OrangeHrms.Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DriverManager {
    public static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver = driver;
    }

    public static void startDriver() {
        if (driver == null) {
            EdgeOptions edge = new EdgeOptions();
            edge.addArguments("--as guest");
            driver = new EdgeDriver(edge);
        }
    }

    public static void downDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
