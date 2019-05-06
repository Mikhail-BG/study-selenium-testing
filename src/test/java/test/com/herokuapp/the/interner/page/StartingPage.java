package test.com.herokuapp.the.interner.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.com.herokuapp.the.interner.util.LocatorProducer;

public class StartingPage extends PageObject
{
    private static final String url = "https://the-internet.herokuapp.com";
    private static final String FILENAME = "/herokuapp/herokuapp_locators.properties";
    private static By abtestLink;

    static
    {
        abtestLink = LocatorProducer.get(FILENAME, "abtest_link");
    }

    public StartingPage(WebDriver webDriver)
    {
        super(webDriver);
    }

    public void gotoAbTest()
    {
        webDriver.get(url);
    }
}
