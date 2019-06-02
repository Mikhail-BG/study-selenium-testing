package test.com.herokuapp.the.internet.test;

import java.util.logging.Logger;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import test.com.herokuapp.the.internet.config.LocalWebDriverManager;
import test.com.herokuapp.the.internet.page.AbstractPageObject;
import test.com.herokuapp.the.internet.util.SoftAssertWrapper;
import test.com.herokuapp.the.internet.util.TimePrinter;

public abstract class PageTestBase<T extends AbstractPageObject>
{
    private static final Logger LOGGER = Logger.getLogger(PageTestBase.class.getName());
    SoftAssertWrapper softAssertWrapper;
    private String testName;
    private String testMethod;

    PageTestBase(String testName)
    {
        this.softAssertWrapper = new SoftAssertWrapper();
        this.testName = testName;
    }

    public abstract T getPage();

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

    @BeforeClass
    public void setUpTest()
    {
        LOGGER.info(TimePrinter.getDateTimeMessage() + " " + testName + " STARTED");
    }

    @BeforeMethod
    public void setUp()
    {
    }

    @AfterMethod
    public void cleanUp()
    {
        LocalWebDriverManager.destroyWebDriver(getPage().getWebDriver());
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
