package org.OrangeHrms.Pages;

import org.OrangeHrms.Base.CommonMeth;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage extends CommonMeth {
    WebDriver driver;
    CommonMeth Cm=new CommonMeth();
    public Loginpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@name='username']")
    private WebElement userName;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement Password;
    @FindBy(xpath = "//*[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")
    private WebElement LoginBtn;
    @FindBy(xpath = "//div[@class='orangehrm-login-branding']")
    private WebElement HeadlineLoginPage;
    @FindBy(xpath = "//*[@class='oxd-text oxd-text--p oxd-alert-content-text']")
    public WebElement error;
    @FindBy(xpath = "//*[@class='oxd-topbar-header-breadcrumb']")
    public WebElement SuccessMessage;

    public String LoginValidCredential(String usern, String pwdd) {
        enterKey(userName,usern);
        enterKey(Password,pwdd);
        clickElement(LoginBtn);
        String success=SuccessMessage.getText();
        ScreenShot();
        return success;
    }
    public String LoginInValidCredential(String username, String pwd) {
        waitsa();
        enterKey(userName,username);
        enterKey(Password,pwd);
        ScreenShot();
        partialScreenshot(HeadlineLoginPage);
        clickElement(LoginBtn);

        System.out.println("......click.....");
        String err=error.getText();
        return err;
    }

}
