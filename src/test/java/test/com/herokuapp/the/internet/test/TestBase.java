package test.com.herokuapp.the.internet.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import test.com.herokuapp.the.internet.config.DriverProducer;

import java.util.logging.Logger;

public class TestBase
{
    protected static final Logger LOGGER = Logger.getLogger(TestBase.class.getName());
    protected WebDriver webDriver;

    TestBase()
    {
        this.webDriver = DriverProducer.initFirefoxWebDriver();
        //this.webDriver = DriverProducer.initGridWebdriver();
    }

    @BeforeTest
    public void setUpDriver()
    {

    }

    @AfterTest
    public void cleanUp()
    {
        webDriver.close();
    }
}
