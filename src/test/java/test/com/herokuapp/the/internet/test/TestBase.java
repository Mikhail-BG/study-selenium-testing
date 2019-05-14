package test.com.herokuapp.the.internet.test;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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
    private String testMethod;

    TestBase(String testName)
    {
        //this.webDriver = DriverProducer.initGridWebdriver();
        this.softAssertWrapper = new SoftAssertWrapper();
        this.testName = testName;
    }

    public String getTestMethod()
    {
        return testMethod;
    }

    public void setTestMethod(String testMethod)
    {
        this.testMethod = testMethod;
    }

    public void logTestMethod(String testMethod)
    {
        setTestMethod(testMethod);
        LOGGER.info(TimePrinter.getDateTimeMessage() + "Started single test method: " + getTestMethod());
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
    public void setUpTest()
    {
        LOGGER.info(TimePrinter.getDateTimeMessage() + " " + testName + " STARTED");
    }

    @BeforeMethod
    public void setUp()
    {
        setWebDriver(DriverProducer.initFirefoxWebDriver());
    }

    @AfterMethod
    public void cleanUp()
    {
        DriverProducer.destroyWebDriver(getWebDriver());
        if (softAssertWrapper.isEmpty())
        {
            LOGGER.info(TimePrinter.getDateTimeMessage() + " " + testMethod + " PASSED");
        }
        else
        {
            throw new RuntimeException(TimePrinter.getDateTimeMessage() + "Test method: " + testMethod + " FAILED");
        }
    }

    @AfterClass
    public void tearDown()
    {
        LOGGER.info(TimePrinter.getDateTimeMessage() + " " + testName + " FINISHED");
    }
}
