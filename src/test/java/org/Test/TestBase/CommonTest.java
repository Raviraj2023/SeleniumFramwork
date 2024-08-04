package org.Test.TestBase;

import org.OrangeHrms.Drivers.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonTest {

    // Driver start
//    down driver
    @BeforeMethod
    public void setup(){
        DriverManager.startDriver();

    }
    @AfterMethod
    public void tearDown(){
        DriverManager.downDriver();
    }
}
