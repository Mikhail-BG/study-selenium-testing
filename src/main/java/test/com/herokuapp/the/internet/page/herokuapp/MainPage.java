package test.com.herokuapp.the.internet.page.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.com.herokuapp.the.internet.constant.url.HerokuappUrl;
import test.com.herokuapp.the.internet.page.PageObject;
import test.com.herokuapp.the.internet.util.LocatorProducer;

public class MainPage extends PageObject
{
    private static By abTestLink;
    private static By addRemoveElementsLink;

    static
    {
        FILENAME = "/herokuapp/herokuapp_locators.properties";
        abTestLink = LocatorProducer.get(FILENAME, "abtest_link");
        addRemoveElementsLink = LocatorProducer.get(FILENAME, "addremoveelements_link");
    }

    public MainPage(WebDriver webDriver)
    {
        super(webDriver);
        url = HerokuappUrl.MAIN;
    }

    @Override
    public void openPage()
    {
        webDriver.get(url);
    }

    public AbTestPage gotoAbTest()
    {
        webDriver.findElement(abTestLink).click();
        return new AbTestPage(webDriver);
    }

    public AddRemoveElementsPage gotoAddRemoveElements()
    {
        webDriver.findElement(addRemoveElementsLink).click();
        return new AddRemoveElementsPage(webDriver);
    }
}
