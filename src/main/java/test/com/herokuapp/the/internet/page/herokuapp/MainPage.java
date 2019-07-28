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
    @FindBy(xpath = "//a[.='Basic Auth']")
    private static WebElement basicAuthLink;
    @FindBy(xpath = "//a[.='Challenging DOM']")
    private static WebElement challengingDom;
    @FindBy(xpath = "//a[.='Checkboxes']")
    private static WebElement checkboxes;

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
     *
     * @return AddRemoveElement page object.
     */
    public AddRemoveElementsPage gotoAddRemoveElements()
    {
        addRemoveElementsLink.click();
        return new AddRemoveElementsPage(getWebDriver());
    }

    /**
     * Forwards to BasicAuth page.
     *
     * @return BasicAuth page object.
     */
    public BasicAuthPage gotoBasicAuthPage()
    {
        final String basicAuthUser = getAllProperties().getProperty("basicAuthUser");
        final String basicAuthPassword = getAllProperties().getProperty("basicAuthPassword");
        final String urlSplitter = "//";
        final String[] basicAuthUrl = basicAuthLink.getAttribute("href").split(urlSplitter);
        basicAuthUrl[1] = urlSplitter + basicAuthUser + ":" + basicAuthPassword + "@" + basicAuthUrl[1];
        final String url = basicAuthUrl[0] + basicAuthUrl[1];
        getWebDriver().get(url);
        return new BasicAuthPage(getWebDriver());
    }

    /**
     * Forwards to Challenging DOM page.
     *
     * @return ChallengingDom page object.
     */
    public ChallengingDomPage gotoChallengingDomPage()
    {
        challengingDom.click();
        return new ChallengingDomPage(getWebDriver());
    }

    /**
     * Forwards to Challenging DOM page.
     *
     * @return Checkboxes page object.
     */
    public CheckboxesPage gotCheckboxesPage()
    {
        checkboxes.click();
        return new CheckboxesPage(getWebDriver());
    }
}
