package test.com.herokuapp.the.internet.page.herokuapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import test.com.herokuapp.the.internet.constant.url.HerokuappUrl;
import test.com.herokuapp.the.internet.page.AbstractPageObject;

/**
 * API fot the main page.
 */
public class MainPage extends AbstractPageObject
{
    @FindBy(xpath = "//a[.='A/B Testing']")
    private static WebElement abTestLink;
    @FindBy(xpath = "//a[.='Add/Remove Elements']")
    private static WebElement addRemoveElementsLink;

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
        abTestLink.click();
        return new AbTestPage(getWebDriver());
    }

    /**
     * Forwards to AddRemoveElement page.
     * @return AddRemoveElement page object.
     */
    public AddRemoveElementsPage gotoAddRemoveElements()
    {
        addRemoveElementsLink.click();
        return new AddRemoveElementsPage(getWebDriver());
    }
}
