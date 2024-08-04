package org.Test.LoginTestcases;

import org.OrangeHrms.Pages.Loginpage;
import org.OrangeHrms.Utils.PropertyReder;
import org.Test.TestBase.CommonTest;
import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static org.OrangeHrms.Drivers.DriverManager.driver;
public class TestLogin extends CommonTest {
    private static final Logger logger = LogManager.getLogger(TestLogin.class);
    Loginpage lg, lg1;
    @Test(enabled = true, priority = 1)
    public void TestValidCredentionals() throws FileNotFoundException {
        lg = new Loginpage(driver);
        logger.info(".......TestStarted......");
        driver.manage().window().maximize();
        lg.openVWOLoginURL();
        lg.waitsa();
        lg.LoginValidCredential(PropertyReder.readKey("UserName"), PropertyReder.readKey("Password"));
        String Successmessage = lg.SuccessMessage.getText();
        Assert.assertEquals(Successmessage, PropertyReder.readKey("SuccessMessage"));
        logger.info(".......TestEnd......");
    }
    @Test(enabled = false, priority = 2)
    public void TestInValidCredentionals() throws FileNotFoundException {
        lg1 = new Loginpage(driver);
        driver.manage().window().maximize();
        lg1.openVWOLoginURL();
        lg1.waitsa();
        String er = lg1.LoginInValidCredential(PropertyReder.readKey("UserName"), PropertyReder.readKey("IPassword"));
        Assert.assertEquals(er, PropertyReder.readKey("ErrorMessage"));
    }
}
