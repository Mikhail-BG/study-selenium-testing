package test.com.herokuapp.the.internet.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import test.com.herokuapp.the.internet.config.logger.LocaleLog;
import test.com.herokuapp.the.internet.config.webdriver.LocalWebDriverManager;
import test.com.herokuapp.the.internet.page.AbstractPageObject;
import test.com.herokuapp.the.internet.util.SoftAssertWrapper;

public abstract class PageTestBase<T extends AbstractPageObject>
{
    SoftAssertWrapper softAssertWrapper;
    private String testName;
    private String testMethod;

    PageTestBase(String testName)
    {
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
        LocaleLog.info("Started single test method: " + getTestMethod());
    }

    @BeforeClass
    public void setUpTest()
    {
        LocaleLog.info("TEST: " + testName + " STARTED");
        this.softAssertWrapper = new SoftAssertWrapper();
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
            LocaleLog.info("Test method: " + testMethod + " PASSED");
        }
        else
        {
            LocaleLog.error("Test method: " + testMethod + " FAILED");
        }
    }

    @AfterClass
    public void tearDown()
    {
        LocaleLog.info("TEST: " + testName + " FINISHED");
    }
}
