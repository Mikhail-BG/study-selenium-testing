package test.com.herokuapp.the.internet.page.herokuapp;

import java.util.List;
import java.util.Random;

import org.apache.commons.collections4.CollectionUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import test.com.herokuapp.the.internet.constant.url.HerokuappUrl;
import test.com.herokuapp.the.internet.page.AbstractPageObject;

/**
 * ... API for Add/Remove Elements page.
 */
public class AddRemoveElementsPage extends AbstractPageObject
{
    @FindBy(xpath = "//h3[1]")
    private WebElement h3Text;
    @FindBy(xpath = "//button[contains(text(),'Add Element')]")
    private WebElement buttonAddElement;
    @FindBy(xpath = "//button[@class='added-manually' and @onclick='deleteElement()']")
    private List<WebElement> buttonRemoveElements;

    /**
     * Default constructor.
     */
    public AddRemoveElementsPage(WebDriver webDriver)
    {
        super(webDriver);
        setUrl(HerokuappUrl.ADD_REMOVE_ELEMENTS);
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
    public String findH3Text()
    {
        return h3Text.getText();
    }

    /**
     * Click on AddElement button.
     */
    public void clickAddButton()
    {
        buttonAddElement.click();
    }

    /**
     * Click on AddElement several times.
     *
     * @param times how many times to click.
     */
    public void clickAddButton(int times)
    {
        int counter = times;
        while (counter > 0)
        {
            clickAddButton();
            counter = --counter;
        }
    }

    /**
     * Calculates the number of Remove buttons.
     *
     * @return number of Remove buttons
     */
    public int countRemoveElement()
    {
        return buttonRemoveElements.size();
    }

    /**
     * Click on random Remove button.
     *
     * @throws RuntimeException in a case of remove buttons absence.
     */
    public void clickDeleteButton()
    {
        if (CollectionUtils.isEmpty(buttonRemoveElements))
        {
            throw new RuntimeException("Remove buttons were not created!");
        }
        else
        {
            final Random random = new Random();
            int buttonNumber = random.nextInt(buttonRemoveElements.size()) - 1;
            if (buttonNumber < 0)
            {
                buttonNumber = 0;
            }
            buttonRemoveElements.get(buttonNumber).click();
        }
    }

    /**
     * Click on number of Delete buttons.
     *
     * @param times amount of Delete buttons.
     */
    public void clickDeleteButton(int times)
    {
        int counter = times;
        while (counter > 0)
        {
            clickDeleteButton();
            counter = --counter;
        }
    }
}
