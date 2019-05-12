package test.com.herokuapp.the.internet.page.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.com.herokuapp.the.internet.constant.url.HerokuappUrl;
import test.com.herokuapp.the.internet.page.PageObject;
import test.com.herokuapp.the.internet.util.LocatorProducer;

public class AbTestPage extends PageObject
{
    private static By h3Text;

    static
    {
        FILENAME = "/herokuapp/herokuapp_abtest_locators.properties";

        h3Text = LocatorProducer.get(FILENAME, "h3text");
    }

    public AbTestPage(WebDriver webDriver)
    {
        super(webDriver);
        url = HerokuappUrl.ABTEST;
    }

    @Override
    public void openPage()
    {
        webDriver.get(url);
    }

    public String getH3Text()
    {
        return webDriver.findElement(h3Text).getText();
    }
}