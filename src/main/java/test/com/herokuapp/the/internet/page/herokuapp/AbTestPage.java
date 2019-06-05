package test.com.herokuapp.the.internet.page.herokuapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import test.com.herokuapp.the.internet.constant.url.HerokuappUrl;
import test.com.herokuapp.the.internet.page.AbstractPageObject;

/**
 * Api for ABTest page.
 */
public class AbTestPage extends AbstractPageObject
{
    @FindBy(xpath = "//h3[1]")
    private WebElement h3Text;

    @FindBy(xpath = "//h3[1]/following-sibling::p[1]")
    private WebElement pageText;

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
     *
     * @return h3 text.
     */
    public String findH3Text()
    {
        return h3Text.getText();
    }

    /**
     * Returns text after h3 tag of the page.
     *
     * @return page after Heading text.
     */
    public String findPageText()
    {
        return pageText.getText();
    }
}
