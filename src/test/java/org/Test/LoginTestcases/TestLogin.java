package org.Test;

import org.OrangeHrms.Pages.Loginpage;
import org.Test.TestBase.CommonTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.OrangeHrms.Drivers.DriverManager.driver;

public class TestLogin extends CommonTest {
//    WebDriver driver;
//
//    @BeforeTest
//    public void initiateBrowser(){
//      driver =new ChromeDriver();
//        driver.get("https://app.vwo.com/#/login");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//    }
    @Test (enabled = false,priority = 1)
    public void TestValidCredentionals(){

        Loginpage lg=new Loginpage(driver);
        driver.manage().window().maximize();
        lg.openVWOLoginURL();
        lg.waitsa();
        String Successmessage=lg.LoginValidCredential("bhosaleravi9421@gmail.com", "Ravi@123");
        Assert.assertEquals(Successmessage,"Hi Raviraj Bhosale, here's an overview of your experience optimization journey");
    }
    @Test (enabled = true, priority = 2)
    public void TestInValidCredentionals(){
        Loginpage lg=new Loginpage(driver);
        driver.manage().window().maximize();
        lg.openVWOLoginURL();
        lg.waitsa();
        String errormessage=lg.LoginInValidCredential("bhosaleravi9421@gmail.com", "Ravi@125");
        Assert.assertEquals(errormessage,"Your email, password, IP address or location did not match");
    }
//    @AfterTest
//    public void closesession(){
////        driver.close();
//        driver.quit();
//    }
}
