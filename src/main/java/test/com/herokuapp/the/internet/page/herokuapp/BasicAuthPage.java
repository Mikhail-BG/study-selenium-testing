package test.com.herokuapp.the.internet.page.herokuapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import test.com.herokuapp.the.internet.constant.url.HerokuappUrl;
import test.com.herokuapp.the.internet.page.AbstractPageObject;

/**
 * ... API for BasicAuth page.
 */
public class BasicAuthPage extends AbstractPageObject
{
    @FindBy(xpath = "//div[@class='example']//p[contains(text(),'proper')]")
    private WebElement mainText;

    /**
     * Default constructor.
     */
    public BasicAuthPage(WebDriver webDriver)
    {
        super(webDriver);
        setUrl(HerokuappUrl.BASIC_AUTH);
    }

    @Override
    public void openPage()
    {
        getWebDriver().get(getUrl());
    }

    /**
     * Return main text to verify the page.
     *
     * @return main text value
     */
    public String getTextOnPage()
    {
        return mainText.getText();
    }
}
