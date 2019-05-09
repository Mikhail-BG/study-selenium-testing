package test.com.herokuapp.the.internet.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import test.com.herokuapp.the.internet.config.DriverProducer;
import test.com.herokuapp.the.internet.util.SoftAssertWrapper;
import test.com.herokuapp.the.internet.util.TimePrinter;

import java.util.logging.Logger;

public class TestBase
{
    static final Logger LOGGER = Logger.getLogger(TestBase.class.getName());
    WebDriver webDriver;
    SoftAssertWrapper softAssertWrapper;
    private String testName;

    TestBase(String testName)
    {
        this.webDriver = DriverProducer.initFirefoxWebDriver();
        //this.webDriver = DriverProducer.initGridWebdriver();
        this.softAssertWrapper = new SoftAssertWrapper();
        this.testName = testName;
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

    @AfterClass
    public void tearDown()
    {
        if (softAssertWrapper.isEmpty())
        {
            LOGGER.info(TimePrinter.getDateTimeMessage() + " " + testName + " PASSED");
        }
        else
        {
            throw new RuntimeException("Test: " + testName + " FAILED");
        }
    }
}
