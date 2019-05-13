package test.com.herokuapp.the.internet.page.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import test.com.herokuapp.the.internet.constant.url.HerokuappUrl;
import test.com.herokuapp.the.internet.page.AbstractPageObject;
import test.com.herokuapp.the.internet.util.LocatorProducer;

/**
 * API fot the main page.
 */
public class MainPage extends AbstractPageObject
{
    private static By abTestLink;
    private static By addRemoveElementsLink;

    static
    {
        setFilename("/herokuapp/herokuapp_locators.properties");
        abTestLink = LocatorProducer.get(getFilename(), "abtest_link");
        addRemoveElementsLink = LocatorProducer.get(getFilename(), "addremoveelements_link");
    }

    /**
     * Default constructor.
     */
    public MainPage(WebDriver webDriver)
    {
        super(webDriver);
        setUrl(HerokuappUrl.MAIN);
    }

    @Override
    public void openPage()
    {
        getWebDriver().get(getUrl());
    }

    /**
     * Forward to ABTest page.
     *
     * @return ABTest page object.
     */
    public AbTestPage gotoAbTest()
    {
        getWebDriver().findElement(abTestLink).click();
        return new AbTestPage(getWebDriver());
    }

    /**
     * Forwards to AddRemoveElement page.
     * @return AddRemoveElement page object.
     */
    public AddRemoveElementsPage gotoAddRemoveElements()
    {
        getWebDriver().findElement(addRemoveElementsLink).click();
        return new AddRemoveElementsPage(getWebDriver());
    }
}
