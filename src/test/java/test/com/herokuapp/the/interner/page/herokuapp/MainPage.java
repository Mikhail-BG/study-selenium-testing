package test.com.herokuapp.the.interner.page.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.com.herokuapp.the.interner.constant.HerokuappUrl;
import test.com.herokuapp.the.interner.page.PageObject;
import test.com.herokuapp.the.interner.util.LocatorProducer;

public class MainPage extends PageObject
{
    private static final String FILENAME = "/herokuapp/herokuapp_locators.properties";
    private static By abTestLink;
    private static By addRemoveElementsLink;

    static
    {
        abTestLink = LocatorProducer.get(FILENAME, "abtest_link");
        addRemoveElementsLink = LocatorProducer.get(FILENAME, "addremoveelements_link");
    }

    public MainPage(WebDriver webDriver)
    {
        super(webDriver);
        url = HerokuappUrl.MAIN;
        webDriver.get(url);
    }

    public void gotoAbTest()
    {
        webDriver.findElement(abTestLink).click();
    }

    public void gotoAddRemoveElements()
    {
        webDriver.findElement(addRemoveElementsLink).click();
    }
}
