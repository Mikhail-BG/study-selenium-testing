package test.com.herokuapp.the.internet.test;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import test.com.herokuapp.the.internet.config.DriverProducer;
import test.com.herokuapp.the.internet.util.SoftAssertWrapper;
import test.com.herokuapp.the.internet.util.TimePrinter;

public class TestBase
{
    static final Logger LOGGER = Logger.getLogger(TestBase.class.getName());
    private WebDriver webDriver;
    SoftAssertWrapper softAssertWrapper;
    private String testName;

    TestBase(String testName)
    {
        //this.webDriver = DriverProducer.initGridWebdriver();
        this.softAssertWrapper = new SoftAssertWrapper();
        this.testName = testName;
    }

    public WebDriver getWebDriver()
    {
        return webDriver;
    }

    public void setWebDriver(WebDriver webDriver)
    {
        this.webDriver = webDriver;
    }

    @BeforeTest
    public void setUp()
    {
        setWebDriver(DriverProducer.initFirefoxWebDriver());
    }

    @AfterTest
    public void cleanUp()
    {
        //TODO close browser after each single test
        DriverProducer.destroyWebDriver(getWebDriver());
        LOGGER.info("TEST FINISHED");
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
