package test.com.herokuapp.the.internet.page.herokuapp;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import test.com.herokuapp.the.internet.constant.url.HerokuappUrl;
import test.com.herokuapp.the.internet.page.AbstractPageObject;
import test.com.herokuapp.the.internet.util.LocatorProducer;

/**
 * ... API for Add/Remove Elements page.
 */
public class AddRemoveElementsPage extends AbstractPageObject
{
    private static By h3Text;
    private static By buttonAddElement;
    private static By buttonRemoveElement;

    static
    {
        setFilename("/herokuapp/herokuapp_addremovelements_locators.properties");
        h3Text = LocatorProducer.get(getFilename(), "h3text");
        buttonAddElement = LocatorProducer.get(getFilename(), "buttonadd");
        buttonRemoveElement = LocatorProducer.get(getFilename(), "buttonremove");
    }

    /**
     * Default constructor.
     */
    public AddRemoveElementsPage(WebDriver webDriver)
    {
        super(webDriver);
        setUrl(HerokuappUrl.ADDREMOVEELEMENTS);
    }

    @Override
    public void openPage()
    {
        getWebDriver().get(getUrl());
    }

    /**
     * Return h3 header text to verify the page.
     *
     * @return h3 text value
     */
    public String getH3Text()
    {
        return getWebDriver().findElement(h3Text).getText();
    }

    /**
     * Click on AddElement button.
     */
    public void clickAddButton()
    {
        getWebDriver().findElement(buttonAddElement).click();
    }

    /**
     * Calculates the number of Remove buttons.
     *
     * @return number of Remove buttons
     */
    public int countRemoveElement()
    {
        return getWebDriver().findElements(buttonRemoveElement).size();
    }

    /**
     * Find remove buttons and click on first remove button.
     *
     * @throws RuntimeException in a case of remove buttons absence.
     */
    public void removeOneElement()
    {
        final List<WebElement> removeButtons = getWebDriver().findElements(buttonRemoveElement);
        if (CollectionUtils.isEmpty(removeButtons))
        {
            throw new RuntimeException("Remove buttons were not created!");
        }
        else
        {
            removeButtons.get(0).click();
        }
    }
}
