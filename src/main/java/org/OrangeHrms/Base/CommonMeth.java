package org.OrangeHrms.Base;

import org.OrangeHrms.Drivers.DriverManager;
import org.OrangeHrms.Pages.Loginpage;
import org.OrangeHrms.Utils.PropertyReder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.logging.FileHandler;

import static java.util.logging.FileHandler.*;
import static org.OrangeHrms.Drivers.DriverManager.driver;
import static org.OrangeHrms.Drivers.DriverManager.getDriver;

public class CommonMeth {
    //    This is for common  methods [OpenURL,Wait,Openfile,Screenshot,...]
    public CommonMeth() {

    }

    TakesScreenshot TCSC;

    public void ScreenShot() {
        TCSC = (TakesScreenshot) driver;

        File source = TCSC.getScreenshotAs(OutputType.FILE);

        File destination = new File("C:\\Users\\raviraj.bhosale\\SeleniumtraningXebia\\SeleniumFreamwork\\Screenshots\\FullPage.png");
        try {
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void partialScreenshot(WebElement ele) {
        File source = ele.getScreenshotAs(OutputType.FILE);

        File destination = new File("C:\\Users\\raviraj.bhosale\\SeleniumtraningXebia\\SeleniumFreamwork\\Screenshots\\PartOfPage.png");
        try {
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void openVWOLoginURL() {
        try {
            getDriver().get(PropertyReder.readKey("URL"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickElement(WebElement by) {
        by.click();
    }

    public void enterKey(WebElement by, String key) {
        by.sendKeys(key);
    }

    public void clickElement(By by) {
        getDriver().findElement(by).click();
    }

    public void enterKey(By by, String key) {
        getDriver().findElement(by).sendKeys(key);
    }

    public WebElement presenceofElement(By elementlocation) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(elementlocation));
    }

    public void waitsa() {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public WebElement visiblityofElement(By by) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement getElement(By key) {
        return getDriver().findElement(key);
    }

    public WebElement getElement(WebElement by) {
        return by;
    }
}
