package test.com.herokuapp.the.internet.page.herokuapp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import test.com.herokuapp.the.internet.constant.url.HerokuappUrl;
import test.com.herokuapp.the.internet.exception.PageProcessRuntimeException;
import test.com.herokuapp.the.internet.page.AbstractPageObject;

/**
 * ... API for ChallengingDOM page.
 */
public class ChallengingDomPage extends AbstractPageObject
{
    @FindBy(xpath = "//h3[1]")
    private WebElement h3Text;

    @FindBy(xpath = "//div[@id='content']//script")
    private WebElement script;

    @FindBy(className = "button")
    private WebElement button;

    @FindBy(className = "button alert")
    private WebElement buttonAlert;

    /**
     * Default constructor.
     */
    public ChallengingDomPage(WebDriver webDriver)
    {
        super(webDriver);
        setUrl(HerokuappUrl.CHALLENGING_DOM);
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
     * Press the button element.
     */
    public void pressButton()
    {
        button.click();
    }

    /**
     * Press the button alert element.
     */
    public void pressButtonAlert()
    {
        buttonAlert.click();
    }

    /**
     * Reads the text for canvas element in generated in script.
     *
     * @return answer value in canvas.
     * @throws PageProcessRuntimeException in a case of result absence.
     */
    public String readCanvasValue()
    {
        final Pattern pattern = Pattern.compile(getAllProperties().getProperty("challengingDomScriptRegex"));
        final Matcher matcher = pattern.matcher(script.getAttribute("innerHTML"));
        if (matcher.find())
        {
            return matcher.group(1);
        }
        else
        {
            throw new PageProcessRuntimeException("No matches found at Challenging DOM page by regex: \""
                    + pattern.toString() + "\"");
        }
    }
}
