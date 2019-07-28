package test.com.herokuapp.the.internet.page.herokuapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import test.com.herokuapp.the.internet.constant.url.HerokuappUrl;
import test.com.herokuapp.the.internet.page.AbstractPageObject;

/**
 * ... API for Checkboxes page.
 */
public class CheckboxesPage extends AbstractPageObject
{
    @FindBy(xpath = "//h3[1]")
    private WebElement h3Text;
    @FindBy(xpath = "//input[@type='checkbox'][1]")
    private WebElement checkboxFirst;
    @FindBy(xpath = "//input[@type='checkbox'][2]")
    private WebElement checkboxSecond;

    /**
     * Default constructor.
     */
    public CheckboxesPage(WebDriver webDriver)
    {
        super(webDriver);
        setUrl(HerokuappUrl.CHECKBOXES);
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
     * Returns state for checkbox 1.
     *
     * @return true if checkbox 1 enabled.
     */
    public boolean getStateCheckboxFirst()
    {
        return checkboxFirst.isSelected();
    }

    /**
     * Click on checkbox 1.
     */
    public void clickCheckboxFirst()
    {
        checkboxFirst.click();
    }

    /**
     * Returns state for checkbox 2.
     *
     * @return true if checkbox 2 enabled.
     */
    public boolean getStateCheckboxSecond()
    {
        return checkboxSecond.isSelected();
    }

    /**
     * Click on checkbox 2.
     */
    public void clickCheckboxSecond()
    {
        checkboxSecond.click();
    }
}
