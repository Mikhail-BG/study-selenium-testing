package test.com.herokuapp.the.interner.test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import test.com.herokuapp.the.interner.config.DriverProducer;

public class TestBase
{
    protected WebDriver webDriver;

    TestBase()
    {
        this.webDriver = DriverProducer.initWebDriver();
    }

    @Before
    public void setUpDriver()
    {

    }

    @After
    public void cleanUp()
    {
        webDriver.close();
    }
}
