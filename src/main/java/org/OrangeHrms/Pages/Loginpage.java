package org.OrangeHrms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
    WebDriver driver;
    public Loginpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@name='username']")
    private WebElement userName;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement Password;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement LoginBtn;
    @FindBy(xpath = "//div[@id='js-notification-box-msg']")
    public WebElement error;
    @FindBy(xpath = "//p[@class='page-sub-title']")
    public WebElement SuccessMessage;

    public void LoginValidCredential(String username, String pwd) {
        userName.sendKeys(username);
        Password.sendKeys(pwd);
        LoginBtn.click();
    }
    public void LoginInValidCredential(String username, String pwd) {
        userName.sendKeys(username);
        Password.sendKeys(pwd);
        LoginBtn.click();
    }

}
