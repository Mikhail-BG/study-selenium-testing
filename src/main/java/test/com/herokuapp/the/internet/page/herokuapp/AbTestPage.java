package test.com.herokuapp.the.internet.page.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import test.com.herokuapp.the.internet.constant.url.HerokuappUrl;
import test.com.herokuapp.the.internet.page.AbstractPageObject;
import test.com.herokuapp.the.internet.util.LocatorProducer;

/**
 * Api for ABTest page.
 */
public class AbTestPage extends AbstractPageObject
{
    private static By h3Text;

    static
    {
        setFilename("/herokuapp/herokuapp_abtest_locators.properties");

        h3Text = LocatorProducer.get(getFilename(), "h3text");
    }

    /**
     * Default constructor.
     */
    public AbTestPage(WebDriver webDriver)
    {
        super(webDriver);
        setUrl(HerokuappUrl.ABTEST);
    }

    @Override
    public void openPage()
    {
        getWebDriver().get(getUrl());
    }

    /**
     * Returns text for h3 tag of the page.
     * @return h3 text.
     */
    public String findH3Text()
    {
        return getWebDriver().findElement(h3Text).getText();
    }
}
